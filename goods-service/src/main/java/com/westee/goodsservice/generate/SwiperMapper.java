package com.westee.goodsservice.generate;

import com.westee.goodsservice.generate.Swiper;
import com.westee.goodsservice.generate.SwiperExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SwiperMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    long countByExample(SwiperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int deleteByExample(SwiperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int insert(Swiper row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int insertSelective(Swiper row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    List<Swiper> selectByExample(SwiperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    Swiper selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByExampleSelective(@Param("row") Swiper row, @Param("example") SwiperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByExample(@Param("row") Swiper row, @Param("example") SwiperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByPrimaryKeySelective(Swiper row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SWIPER
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByPrimaryKey(Swiper row);
}