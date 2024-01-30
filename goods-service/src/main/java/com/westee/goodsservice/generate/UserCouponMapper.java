package com.westee.goodsservice.generate;

import com.westee.goodsservice.generate.UserCoupon;
import com.westee.goodsservice.generate.UserCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserCouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    long countByExample(UserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int deleteByExample(UserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int insert(UserCoupon row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int insertSelective(UserCoupon row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    List<UserCoupon> selectByExample(UserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    UserCoupon selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByExampleSelective(@Param("row") UserCoupon row, @Param("example") UserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByExample(@Param("row") UserCoupon row, @Param("example") UserCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByPrimaryKeySelective(UserCoupon row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_COUPON
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByPrimaryKey(UserCoupon row);
}