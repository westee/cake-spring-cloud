package com.westee.goodsservice.service;

import com.github.pagehelper.PageHelper;
import com.westee.common.entity.PageResponse;
import com.westee.common.exception.HttpException;
import com.westee.common.utils.Utils;
import com.westee.goodsservice.entity.ShopStatus;
import com.westee.goodsservice.generate.Shop;
import com.westee.goodsservice.generate.ShopExample;
import com.westee.goodsservice.generate.ShopMapper;
import com.westee.goodsservice.redis.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShopService {

    private final ShopMapper shopMapper;
    private final UserRedisService userRedisService;

    @Autowired
    public ShopService(ShopMapper mapper, UserRedisService userRedisService) {
        this.shopMapper = mapper;
        this.userRedisService = userRedisService;
    }

    public PageResponse<Shop> getShopsByUserId(Integer pageNum, Integer pageSize) {
        ShopExample shopExample = new ShopExample();
        shopExample.createCriteria().andOwnerUserIdEqualTo(getUserId()).andStatusEqualTo(ShopStatus.OK.getName());
        long count = shopMapper.countByExample(shopExample);
        long totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> shops = shopMapper.selectByExample(shopExample);
        return PageResponse.pageData(pageNum, pageSize, totalPage, shops);
    }

    public Shop createShop(Shop shop) {
        shop.setOwnerUserId(getUserId());
        shop.setId(null);
        shop.setStatus(ShopStatus.OK.getName());
        shop.setUpdatedAt(Utils.getNow());
        shop.setCreatedAt(Utils.getNow());
        shopMapper.insertSelective(shop);
        return shop;
    }

    public Shop updateShop(Shop shop) {
        if (Objects.isNull(shop.getId())) {
            throw HttpException.forbidden("店铺参数不合法");
        }
        checkAuth(shop.getId());

        shop.setUpdatedAt(Utils.getNow());
        shop.setCreatedAt(Utils.getNow());
        shopMapper.updateByPrimaryKeySelective(shop);
        return shop;
    }

    public Shop deleteShop(Long shopId) {
        checkAuth(shopId);
        Shop shop = new Shop();
        shop.setId(shopId);
        shop.setStatus(ShopStatus.DELETED.getName());
        shop.setUpdatedAt(Utils.getNow());
        shop.setCreatedAt(Utils.getNow());
        shopMapper.updateByPrimaryKeySelective(shop);
        return shop;
    }

    public Shop getShopByShopId(long shopId) {
        return shopMapper.selectByPrimaryKey(shopId);
    }

    public Long getUserId() {
        return userRedisService.getUser().getId();
    }

    private void checkAuth(Long shopId) {
        Shop shopResult = shopMapper.selectByPrimaryKey(shopId);
        if (Objects.equals(shopResult, null)) {
            throw HttpException.forbidden("参数不合法");
        }

        Long ownerUserId = shopResult.getOwnerUserId();
        if (!Objects.equals(ownerUserId, getUserId())) {
            throw HttpException.forbidden("拒绝访问");
        }
    }

}
