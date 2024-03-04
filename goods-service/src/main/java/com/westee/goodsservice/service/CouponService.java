package com.westee.goodsservice.service;


import com.github.pagehelper.PageHelper;
import com.westee.common.entity.PageResponse;
import com.westee.common.entity.Response;
import com.westee.common.exception.HttpException;
import com.westee.common.utils.Utils;
import com.westee.goodsservice.generate.Coupon;
import com.westee.goodsservice.generate.CouponExample;
import com.westee.goodsservice.generate.CouponMapper;
import com.westee.goodsservice.generate.UserCoupon;
import com.westee.goodsservice.generate.UserCouponExample;
import com.westee.goodsservice.generate.UserCouponMapper;
import com.westee.goodsservice.mapper.MyUserCouponMapper;
import com.westee.goodsservice.redis.UserRedisService;
import com.westee.openfeign.client.RoleServiceProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CouponService {

    private final CouponMapper couponMapper;
    private final UserCouponMapper userCouponMapper;
    private final RoleServiceProviderClient roleServiceProviderClient;
    private final UserRedisService userRedisService;
    private final MyUserCouponMapper myUserCouponMapper;

    @Autowired
    public CouponService(CouponMapper couponMapper, UserCouponMapper userCouponMapper,
                         UserRedisService userRedisService,
                         RoleServiceProviderClient roleServiceProviderClient, MyUserCouponMapper myUserCouponMapper) {
        this.couponMapper = couponMapper;
        this.userCouponMapper = userCouponMapper;
        this.userRedisService = userRedisService;
        this.roleServiceProviderClient = roleServiceProviderClient;
        this.myUserCouponMapper = myUserCouponMapper;
    }

    /**
     * 计算更新用户总余额
     * 新建一条充值记录
     *
     * @param coupon  充值金额
     * @return       充值记录
     */
    public Coupon insertCoupon(Coupon coupon) {
        coupon.setCreatedAt(Utils.getNow());
        coupon.setUpdatedAt(Utils.getNow());
        couponMapper.insert(coupon);
        return coupon;
    }

    public PageResponse<Coupon> getCouponList(Integer pageNum, Integer pageSize) {
        CouponExample couponExample = new CouponExample();
        couponExample.setOrderByClause("`CREATED_AT` DESC");
        long count = couponMapper.countByExample(couponExample);
        long totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        PageHelper.startPage(pageNum, pageSize);
        List<Coupon> couponList = couponMapper.selectByExample(couponExample);

        return PageResponse.pageData(pageNum, pageSize, totalPage, couponList);
    }

    /**
     * @param couponId 优惠券id
     */
    public void insertUserCoupon(long couponId) {
        Response<List<Long>> userIds = roleServiceProviderClient.getUsersIds(TokenContext.getCurrentToken());
        myUserCouponMapper.batchInsertUserCoupon(userIds.getData(), couponId, false, Utils.getNow());
    }

    public ArrayList<Coupon> getUserCouponList(String status) {
        // 查出用户有多少未使用优惠券
        UserCouponExample userCouponExample = new UserCouponExample();
        userCouponExample.setOrderByClause("`CREATED_AT` DESC");
        UserCouponExample.Criteria criteria = userCouponExample.createCriteria();
        criteria.andUserIdEqualTo(userRedisService.getUser().getId());

         if(Objects.equals(CouponStatus.UNUSED.getName(), status)) {
            criteria.andUsedEqualTo(false);
        } else if(Objects.equals(CouponStatus.USED.getName(), status)) {
            criteria.andUsedEqualTo(true);
        }
        List<UserCoupon> userCoupons = userCouponMapper.selectByExample(userCouponExample);

        // 根据优惠券id 以及起止时间查询优惠券
        ArrayList<Coupon> coupons = new ArrayList<>();
        userCoupons.forEach(userCoupon -> {
            CouponExample couponExample = new CouponExample();
            couponExample.createCriteria().andStartDateLessThanOrEqualTo(Utils.getNow()).andEndDateGreaterThan(Utils.getNow())
                    .andIdEqualTo(userCoupon.getCouponId());
            List<Coupon> couponList = couponMapper.selectByExample(couponExample);
            if(!couponList.isEmpty()) {
                coupons.add(couponList.get(0));
            }
        });

        return coupons;
    }

    public long countUserCoupon() {
        UserCouponExample userCouponExample = new UserCouponExample();
        userCouponExample.createCriteria().andUserIdEqualTo(userRedisService.getUser().getId()).andUsedEqualTo(false);
        List<UserCoupon> userCoupons = userCouponMapper.selectByExample(userCouponExample);

        List<Long> couponIdList = userCoupons.stream()
                .map(UserCoupon::getCouponId)
                .collect(Collectors.toList());
        if (couponIdList.isEmpty()) {
            return 0;
        }

        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andIdIn(couponIdList).andEndDateGreaterThan(Utils.getNow());
        return couponMapper.countByExample(couponExample);
    }

    public void checkCouponExist(Long couponId) {
        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        if(Objects.isNull(coupon)) {
            throw HttpException.notFound("优惠券不存在");
        }
    }

    public enum CouponStatus {
        ALL,
        USED,
        UNUSED;

        public Object getName() {
            return name().toLowerCase();
        }
    }

}
