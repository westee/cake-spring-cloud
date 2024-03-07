package com.westee.orderservice.generate;

import com.westee.orderservice.generate.OrderGoods;
import com.westee.orderservice.generate.OrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    long countByExample(OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int deleteByExample(OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int insert(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int insertSelective(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    List<OrderGoods> selectByExample(OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    OrderGoods selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int updateByPrimaryKeySelective(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_GOODS
     *
     * @mbg.generated Thu Mar 07 22:35:38 CST 2024
     */
    int updateByPrimaryKey(OrderGoods record);
}