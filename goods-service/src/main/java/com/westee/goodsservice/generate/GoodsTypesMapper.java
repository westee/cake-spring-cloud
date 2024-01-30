package com.westee.goodsservice.generate;

import com.westee.goodsservice.generate.GoodsTypes;
import com.westee.goodsservice.generate.GoodsTypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsTypesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    long countByExample(GoodsTypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int deleteByExample(GoodsTypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int insert(GoodsTypes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int insertSelective(GoodsTypes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    List<GoodsTypes> selectByExample(GoodsTypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    GoodsTypes selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByExampleSelective(@Param("record") GoodsTypes record, @Param("example") GoodsTypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByExample(@Param("record") GoodsTypes record, @Param("example") GoodsTypesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByPrimaryKeySelective(GoodsTypes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GOODS_TYPES
     *
     * @mbg.generated Thu Jan 25 14:33:29 CST 2024
     */
    int updateByPrimaryKey(GoodsTypes record);
}