package com.westee.goodsservice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MyUserCouponMapper {

    void batchInsertUserCoupon(List<Long> userIds, long couponId, boolean used, LocalDateTime now);
}
