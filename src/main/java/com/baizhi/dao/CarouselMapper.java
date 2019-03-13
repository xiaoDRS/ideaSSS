package com.baizhi.dao;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselMapper {
    List<Carousel> selectAll();

    int deleteByPrimaryKey(String id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
}