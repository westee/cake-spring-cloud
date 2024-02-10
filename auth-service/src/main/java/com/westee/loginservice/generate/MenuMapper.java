package com.westee.loginservice.generate;

import com.westee.loginservice.generate.Menu;
import com.westee.loginservice.generate.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    long countByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int deleteByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MENU
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    int updateByPrimaryKey(Menu record);
}