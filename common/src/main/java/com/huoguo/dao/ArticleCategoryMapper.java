package com.huoguo.dao;

import com.huoguo.bean.ArticleCategory;

import java.util.ArrayList;

public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);

    //查询文章所属的个人分类
    String findName(Integer articlecategoryId);

    ArrayList<ArticleCategory> findAllByUid(Integer uid);
}