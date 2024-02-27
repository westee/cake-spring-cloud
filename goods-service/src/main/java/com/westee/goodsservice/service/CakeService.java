package com.westee.goodsservice.service;

import com.github.pagehelper.PageHelper;
import com.westee.common.entity.PageResponse;
import com.westee.common.exception.HttpException;
import com.westee.common.utils.Utils;
import com.westee.goodsservice.entity.CakeWithTag;
import com.westee.goodsservice.generate.Cake;
import com.westee.goodsservice.generate.CakeExample;
import com.westee.goodsservice.generate.CakeMapper;
import com.westee.goodsservice.generate.CakeTagMapping;
import com.westee.goodsservice.generate.CakeTagMappingExample;
import com.westee.goodsservice.generate.CakeTagMappingMapper;
import com.westee.goodsservice.mapper.MyCakeWithTagMapper;
import com.westee.goodsservice.redis.RoleRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CakeService {

    private final CakeMapper cakeMapper;
    private final CakeTagMappingMapper cakeTagMappingMapper;
    private final MyCakeWithTagMapper myCakeWithTagMapper;
    private final RoleRedisService roleRedisService;


    @Autowired
    public CakeService(CakeMapper cakeMapper, CakeTagMappingMapper cakeTagMappingMapper,
                       MyCakeWithTagMapper myCakeWithTagMapper, RoleRedisService roleRedisService) {
        this.cakeMapper = cakeMapper;
        this.cakeTagMappingMapper = cakeTagMappingMapper;
        this.myCakeWithTagMapper = myCakeWithTagMapper;
        this.roleRedisService = roleRedisService;
    }

    public PageResponse<CakeWithTag> getCakeList(Integer pageNum, Integer pageSize) {
        CakeExample cakeExample = new CakeExample();
        cakeExample.setOrderByClause("`CREATED_AT` DESC");
        long count = cakeMapper.countByExample(cakeExample);
        long totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        PageHelper.startPage(pageNum, pageSize);
        List<Cake> cakes = cakeMapper.selectByExample(cakeExample);
        List<CakeWithTag> collect = cakes.stream().map(cake -> {
            Long id = cake.getId();
            return myCakeWithTagMapper.selectCakeWithTagsByCakeId(id);
        }).collect(Collectors.toList());

        return PageResponse.pageData(pageNum, pageSize, totalPage, collect);
    }

    public PageResponse<CakeWithTag> getCakeByCakeTag(Integer pageNum, Integer pageSize, Integer categoryId) {
        CakeTagMappingExample cakeTagMappingExample = new CakeTagMappingExample();
        cakeTagMappingExample.createCriteria().andTagIdEqualTo(String.valueOf(categoryId));
        PageHelper.startPage(pageNum, pageSize);
        List<CakeTagMapping> cakeTagMappings = cakeTagMappingMapper.selectByExample(cakeTagMappingExample);
        ArrayList<Cake> cakes = new ArrayList<>();
        cakeTagMappings.forEach(cakeTagMapping -> cakes.add(cakeMapper.selectByPrimaryKey(Long.valueOf(cakeTagMapping.getCakeId()))));

        long count = cakeTagMappingMapper.countByExample(cakeTagMappingExample);
        long totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        List<CakeWithTag> collect = cakes.stream().map(cake -> {
            Long id = cake.getId();
            return myCakeWithTagMapper.selectCakeWithTagsByCakeId(id);
        }).collect(Collectors.toList());

        return PageResponse.pageData(pageNum, pageSize, totalPage, collect);
    }

    public PageResponse<CakeWithTag> getCakeByCakeName(Integer pageNum, Integer pageSize, String keyword) {
        // 计算分页偏移量
        int offset = (pageNum - 1) * pageSize;
        Integer count = myCakeWithTagMapper.countByNameLike(keyword);
        int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        List<CakeWithTag> cakeWithTags = myCakeWithTagMapper.selectByNameLike(keyword, pageSize, offset);

        return PageResponse.pageData(pageNum, pageSize, totalPage, cakeWithTags);
    }

    public Cake insertCake(CakeWithTag cake) {
        checkAuthorization();
        cake.setCreatedAt(Utils.getNow());
        cake.setUpdatedAt(Utils.getNow());
        cake.setDeleted(false);
        cakeMapper.insert(cake);

        insertCakeTagMapping(cake);
        return cake;
    }

    public Cake updateCake(CakeWithTag cake) {
        checkAuthorization();
        cake.setUpdatedAt(Utils.getNow());
        cakeMapper.updateByPrimaryKeySelective(cake);

        // 删除旧的cake tag mapping
        CakeTagMappingExample cakeTagMappingExample = new CakeTagMappingExample();
        cakeTagMappingExample.createCriteria().andCakeIdEqualTo(String.valueOf(cake.getId()));
        cakeTagMappingMapper.deleteByExample(cakeTagMappingExample);

        // 插入新的cake tag mapping
        insertCakeTagMapping(cake);

        return cake;
    }

    public void insertCakeTagMapping (CakeWithTag cake) {
        // 插入新的cake tag mapping
        cake.getTags().forEach(tag -> {
            CakeTagMapping cakeTagMapping = new CakeTagMapping();
            cakeTagMapping.setCakeId(cake.getId().toString());
            cakeTagMapping.setTagId(tag.getId().toString());
            cakeTagMapping.setDeleted(false);
            cakeTagMapping.setCreatedAt(Utils.getNow());
            cakeTagMapping.setUpdatedAt(Utils.getNow());
            cakeTagMappingMapper.insert(cakeTagMapping);
        });
    }

    public Cake deleteCakeByCakeId(long cakeId) {
        checkAuthorization();

        Cake cakeSelective = new Cake();
        cakeSelective.setDeleted(true);
        cakeSelective.setId(cakeId);
        cakeSelective.setUpdatedAt(Utils.getNow());
        cakeMapper.updateByPrimaryKeySelective(cakeSelective);
        return cakeSelective;
    }

    private void checkAuthorization() {
        if (!"admin".equals(roleRedisService.getUserRole().getName())) throw HttpException.forbidden("没有权限");
    }

}
