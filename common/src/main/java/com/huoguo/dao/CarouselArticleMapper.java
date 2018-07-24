package com.huoguo.dao;

import com.huoguo.bean.CarouselArticle;

import java.util.ArrayList;

public interface CarouselArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarouselArticle record);

    int insertSelective(CarouselArticle record);

    CarouselArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarouselArticle record);

    int updateByPrimaryKey(CarouselArticle record);

    ArrayList<CarouselArticle> findAll();
}