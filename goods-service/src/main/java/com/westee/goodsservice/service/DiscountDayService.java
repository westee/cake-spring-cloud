package com.westee.goodsservice.service;

import com.github.pagehelper.PageHelper;
import com.westee.common.entity.PageResponse;
import com.westee.common.exception.HttpException;
import com.westee.common.utils.Utils;
import com.westee.goodsservice.entity.GoodsWithImages;
import com.westee.goodsservice.generate.DiscountDay;
import com.westee.goodsservice.generate.DiscountDayExample;
import com.westee.goodsservice.generate.DiscountDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscountDayService {
    private final DiscountDayMapper discountDayMapper;
    private final GoodsService goodsService;

    @Autowired
    public DiscountDayService(GoodsService goodsService,
                              DiscountDayMapper discountDayMapper) {
        this.discountDayMapper = discountDayMapper;
        this.goodsService = goodsService;
    }

    /**
     * @TODO 需要admin
     */
    public PageResponse<DiscountDay> getDiscountDayList(Integer pageNum, Integer pageSize) {
        DiscountDayExample discountDayExample = new DiscountDayExample();
        discountDayExample.setOrderByClause("`CREATED_AT` DESC");
        discountDayExample.createCriteria().andDisabledEqualTo(false);
        long count = discountDayMapper.countByExample(discountDayExample);
        long totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        PageHelper.startPage(pageNum, pageSize);
        List<DiscountDay> discountDays = discountDayMapper.selectByExample(discountDayExample);
        discountDays.forEach(this::getGoodsName);

        return PageResponse.pageData(pageNum, pageSize, totalPage, discountDays);
    }

    public void getGoodsName(DiscountDay discountDay) {
        GoodsWithImages goodsByGoodsId = goodsService.getGoodsByGoodsId(discountDay.getGoodsId());
        discountDay.setGoodsName(goodsByGoodsId.getName());
        discountDay.setOriginPrice(goodsByGoodsId.getPrice());
    }

    /**
     * @TODO 需要admin
     */
    public DiscountDay createDiscountDay(DiscountDay discountDay) {
        DiscountDayExample example = new DiscountDayExample();
        example.createCriteria().andGoodsIdEqualTo(discountDay.getGoodsId());
        List<DiscountDay> result = discountDayMapper.selectByExample(example);
        if (!result.isEmpty()) {
            // GOODS_ID already exists
            throw HttpException.badRequest("商品活动日已设置，请重新选择商品");
        }
        discountDay.setDisabled(false);
        LocalDateTime date = Utils.getNow();
        discountDay.setCreatedAt(date);
        discountDay.setUpdatedAt(date);
        discountDayMapper.insert(discountDay);
        getGoodsName(discountDay);

        return discountDay;
    }

    /**
     * @TODO 需要admin
     */
    public DiscountDay updateDiscountDay(DiscountDay discountDay) {
        discountDay.setUpdatedAt(Utils.getNow());
        discountDayMapper.updateByPrimaryKeySelective(discountDay);
        getGoodsName(discountDay);
        return discountDay;
    }

    /**
     * @TODO 需要admin
     */
    public DiscountDay deleteDiscountDay(int discountDayId) {
        DiscountDay discountDay = new DiscountDay();
        discountDay.setId(discountDayId);
        discountDay.setDisabled(true);
        discountDayMapper.updateByPrimaryKeySelective(discountDay);
        return discountDay;
    }

}
