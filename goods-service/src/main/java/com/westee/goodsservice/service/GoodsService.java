package com.westee.goodsservice.service;

import com.westee.common.entity.PageResponse;
import com.westee.common.exception.HttpException;
import com.westee.common.utils.Utils;
import com.westee.goodsservice.entity.GoodsStatus;
import com.westee.goodsservice.entity.GoodsWithImages;
import com.westee.goodsservice.generate.DiscountDay;
import com.westee.goodsservice.generate.DiscountDayExample;
import com.westee.goodsservice.generate.DiscountDayMapper;
import com.westee.goodsservice.generate.Goods;
import com.westee.goodsservice.generate.GoodsExample;
import com.westee.goodsservice.generate.GoodsImage;
import com.westee.goodsservice.generate.GoodsImageExample;
import com.westee.goodsservice.generate.GoodsImageMapper;
import com.westee.goodsservice.generate.GoodsMapper;
import com.westee.goodsservice.generate.Shop;
import com.westee.goodsservice.generate.ShopMapper;
import com.westee.goodsservice.mapper.MyGoodsMapper;
import com.westee.goodsservice.mapper.MyGoodsWithImageMapper;
import com.westee.goodsservice.redis.RoleRedisService;
import com.westee.goodsservice.redis.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    private final GoodsMapper goodsMapper;
    private final ShopMapper shopMapper;
    private final GoodsImageMapper goodsImageMapper;
    private final MyGoodsWithImageMapper myGoodsWithImageMapper;
    private final MyGoodsMapper myGoodsMapper;
    private final DiscountDayMapper discountDayMapper;
    private final RoleRedisService roleRedisService;
    private final UserRedisService userRedisService;

    @Autowired
    public GoodsService(GoodsMapper goodsMapper, ShopMapper shopMapper, GoodsImageMapper goodsImageMapper,
                        MyGoodsWithImageMapper myGoodsWithImageMapper, MyGoodsMapper myGoodsMapper,
                        DiscountDayMapper discountDayMapper, RoleRedisService roleRedisService,
                        UserRedisService userRedisService) {
        this.goodsMapper = goodsMapper;
        this.shopMapper = shopMapper;
        this.myGoodsMapper = myGoodsMapper;
        this.goodsImageMapper = goodsImageMapper;
        this.myGoodsWithImageMapper = myGoodsWithImageMapper;
        this.discountDayMapper = discountDayMapper;
        this.roleRedisService = roleRedisService;
        this.userRedisService = userRedisService;
    }

    public PageResponse<GoodsWithImages> getGoodsByShopIdAndCategoryId(Integer pageNum, Integer pageSize, Long shopId,
                                                                       String status) {

        Shop shop = shopMapper.selectByPrimaryKey(shopId);
        if (shop != null) {
            GoodsExample goodsExample = new GoodsExample();
            String statusString = "ok|deleted";
            if (statusString.contains(status)) {
                goodsExample.createCriteria().andStatusEqualTo(status);
            } else {
                goodsExample.createCriteria().andStockEqualTo(0);
            }
            long count = goodsMapper.countByExample(goodsExample);
            long totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
            int offset = (pageNum - 1) * pageSize;
            List<GoodsWithImages> goodsListWithImageByShopId =
                    myGoodsWithImageMapper.getGoodsListWithImageByShopId(shopId, pageSize, offset, status);
            goodsListWithImageByShopId.forEach(goodsWithImages -> goodsWithImages.setVipPrice(getGoodsDiscountPrice(goodsWithImages)));
            return PageResponse.pageData(pageNum, pageSize, totalPage, goodsListWithImageByShopId);
        }
        throw HttpException.badRequest("参数错误");

    }

    public List<GoodsWithImages> getGoodsByShopIdAndCategoryId(Long shopId, Long categoryId) {
        Shop shop = shopMapper.selectByPrimaryKey(shopId);
        if (shop != null) {
            GoodsExample goodsExample = new GoodsExample();
            goodsExample.createCriteria().andCategoryIdEqualTo(categoryId).andStatusEqualTo(GoodsStatus.OK.getName());
            List<GoodsWithImages> goodsListWithImageByShopIdAndCategory = myGoodsWithImageMapper.getGoodsListWithImageByShopIdAndCategory(shopId, categoryId);
            goodsListWithImageByShopIdAndCategory.forEach(goodsWithImages -> goodsWithImages.setVipPrice(getGoodsDiscountPrice(goodsWithImages)));
            return goodsListWithImageByShopIdAndCategory;
        }
        throw HttpException.forbidden("没有权限");
    }

    public GoodsWithImages getGoodsByGoodsId(long goodsId) {
        GoodsWithImages goodsWithImage = myGoodsWithImageMapper.getGoodsWithImage(goodsId);
        goodsWithImage.setVipPrice(getGoodsDiscountPrice(goodsWithImage));
        return goodsWithImage;
    }

    public GoodsWithImages createGoods(GoodsWithImages goods) {
        checkAdminRole();
        checkGoodsBelongToUser(goods);

        goods.setCreatedAt(Utils.getNow());
        goods.setUpdatedAt(Utils.getNow());
        goods.setStatus(GoodsStatus.OK.getName());
        if (checkFieldsLegal(goods)) {
            goodsMapper.insert(goods);
            insertGoodsImage(goods.getImages(), goods.getId());
        } else {
            throw HttpException.badRequest("参数不合法");
        }
        return goods; // myGoodsWithImageMapper.getGoodsWithImage(goods.getId());
    }

    private void insertGoodsImage(List<String> images, long goodsId) {
        images.forEach(item -> {
            GoodsImage goodsImage = new GoodsImage();
            goodsImage.setOwnerGoodsId(goodsId);
            goodsImage.setUrl(item);
            goodsImage.setCreatedAt(Utils.getNow());
            goodsImage.setUpdatedAt(Utils.getNow());
            goodsImageMapper.insertSelective(goodsImage);
        });
    }

    public GoodsWithImages updateGoods(GoodsWithImages goods) {
        checkAdminRole();
        checkGoodsBelongToUser(goods);

        goods.setUpdatedAt(Utils.getNow());
        goods.setCreatedAt(Utils.getNow());
        goodsMapper.updateByPrimaryKeySelective(goods);
        insertGoodsImage(goods.getImages(), goods.getId());
        return myGoodsWithImageMapper.getGoodsWithImage(goods.getId());
    }

    public Goods deleteGoods(Long goodsId) {
        Goods goods = new Goods();
        goods.setId(goodsId);
        checkAdminRole();
        checkGoodsBelongToUser(goods);

        goods.setStatus(GoodsStatus.DELETED.getName());
        goods.setUpdatedAt(Utils.getNow());
        goodsMapper.updateByPrimaryKeySelective(goods);
        return goods;
    }

    public Map<Long, Goods> getGoodsToMapByGoodsIds(List<Long> goodsIds) {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIdIn(goodsIds);
        List<Goods> goods = goodsMapper.selectByExample(example);
        GoodsImageExample goodsImageExample = new GoodsImageExample();
        goods.forEach(item -> {
            goodsImageExample.createCriteria().andOwnerGoodsIdEqualTo(item.getId());
            List<GoodsImage> goodsImages = goodsImageMapper.selectByExample(goodsImageExample);
            if (goodsImages.isEmpty()) {
                item.setImgUrl("");
            } else {
                item.setImgUrl(goodsImages.get(0).getUrl());
            }
        });
        return goods.stream().collect(Collectors.toMap(Goods::getId, x -> x));
    }

    public List<Goods> getGoodsByName(int pageNum, int pageSize, String goodsName) {
        List<Goods> goodsList = myGoodsMapper.selectGoodsByName(pageNum, pageSize, goodsName);
        goodsList.forEach(goods -> goods.setVipPrice(getGoodsDiscountPrice(goods)));
        return goodsList;
    }

    public int countGoodsByName(String goodsName) {
        return myGoodsMapper.countGoodsByName(goodsName);
    }

    /**
     * 折扣日
     * 活动价格放在vip price中
     *
     * @param goods 商品
     * @return 优惠价格
     */
    public BigDecimal getGoodsDiscountPrice(Goods goods) {
        DiscountDayExample discountDayExample = new DiscountDayExample();
        discountDayExample.createCriteria().andGoodsIdEqualTo(goods.getId());
        List<DiscountDay> discountDays = discountDayMapper.selectByExample(discountDayExample);
        if (discountDays.isEmpty()) {
            return null;
        }
        DiscountDay discountDay = discountDays.get(0);
        if (discountDay.getDisabled() || !isDiscountDay(discountDay.getDays())) {
            return null;
        }
        return discountDay.getPrice();
    }

    public boolean checkFieldsLegal(Goods goods) {
        boolean isLegal = true;

        // 检查价格是否合法
        double price = goods.getPrice().doubleValue();
        if (price < 0 || price > 100000) {
            isLegal = false;
        }
        // 检查 VIP 价格是否合法
        BigDecimal vipPrice = goods.getVipPrice();
        if (vipPrice.compareTo(BigDecimal.ZERO) < 0 || vipPrice.compareTo(BigDecimal.valueOf(100000)) > 0) {
            isLegal = false;
        }
        // 检查库存是否合法
        int stock = goods.getStock();
        if (stock < 0 || stock > 500) {
            isLegal = false;
        }
        // 如果所有字段都是合法的，则返回 true
        return isLegal;
    }

    public void checkGoodsBelongToUser(Goods goods) {
        // 根据goods的shop查询当前用户是不是店铺的拥有者
        Long goodsId = goods.getId();
        Goods goodsResult;
        Shop shopResult;
        // 非新创建商品 删除商品时只传了商品id
        if (goodsId != null) {
            goodsResult = goodsMapper.selectByPrimaryKey(goodsId);
            Optional.ofNullable(goodsResult).orElseThrow(() -> HttpException.notFound("商品不存在"));
            Long shopId = goodsResult.getShopId();
            shopResult = shopMapper.selectByPrimaryKey(shopId);
        } else {
            // 新创建的商品 没有商品id
            shopResult = shopMapper.selectByPrimaryKey(goods.getShopId());
        }
        if (shopResult == null) {
            throw HttpException.forbidden("参数不合法");
        }
        if (!Objects.equals(shopResult.getOwnerUserId(), userRedisService.getUser().getId())) {
            throw HttpException.forbidden("拒绝访问");
        }
    }

    public boolean isDiscountDay(String days) {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeekStr = String.valueOf(dayOfWeek - 1);
        return days.contains(dayOfWeekStr);
    }

    public void checkAdminRole() {
        if (!Objects.equals(roleRedisService.getUserRole().getName(), "admin")) {
            throw HttpException.notAuthorized("没有权限");
        }
    }

}
