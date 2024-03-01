package com.westee.goodsservice.mapper;

import com.westee.goodsservice.entity.CakeWithTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyCakeWithTagMapper {
    CakeWithTag selectCakeWithTagsByCakeId(@Param("cakeId") long cakeId);
    List<CakeWithTag> selectByNameLike(@Param("name") String name,
                                       @Param("pageSize") Integer pageSize,
                                       @Param("offset") Integer offset);
    Integer countByNameLike(@Param("name") String name);
}
