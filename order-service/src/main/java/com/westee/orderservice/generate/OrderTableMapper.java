package com.westee.orderservice.generate;

import com.westee.orderservice.generate.OrderTable;
import com.westee.orderservice.generate.OrderTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    long countByExample(OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int deleteByExample(OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int insert(OrderTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int insertSelective(OrderTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    List<OrderTable> selectByExample(OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    OrderTable selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int updateByExampleSelective(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int updateByExample(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int updateByPrimaryKeySelective(OrderTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_TABLE
     *
     * @mbg.generated Fri Mar 01 21:54:47 CST 2024
     */
    int updateByPrimaryKey(OrderTable record);
}