package com.westee.goodsservice.generate;

import com.westee.goodsservice.generate.GoodsImage;
import com.westee.goodsservice.generate.GoodsImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    long countByExample(GoodsImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int deleteByExample(GoodsImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int insert(GoodsImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int insertSelective(GoodsImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    List<GoodsImage> selectByExample(GoodsImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    GoodsImage selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByExampleSelective(@Param("record") GoodsImage record, @Param("example") GoodsImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByExample(@Param("record") GoodsImage record, @Param("example") GoodsImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByPrimaryKeySelective(GoodsImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_IMAGE
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByPrimaryKey(GoodsImage record);
}