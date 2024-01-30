package com.westee.goodsservice.generate;

import com.westee.goodsservice.generate.Shop;
import com.westee.goodsservice.generate.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    long countByExample(ShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int deleteByExample(ShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int insert(Shop row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int insertSelective(Shop row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    List<Shop> selectByExample(ShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    Shop selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByExampleSelective(@Param("row") Shop row, @Param("example") ShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByExample(@Param("row") Shop row, @Param("example") ShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByPrimaryKeySelective(Shop row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    int updateByPrimaryKey(Shop row);
}