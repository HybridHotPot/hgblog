package com.huoguo.dao;

import com.huoguo.bean.CollectionArticle;

public interface CollectionArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectionArticle record);

    int insertSelective(CollectionArticle record);

    CollectionArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectionArticle record);

    int updateByPrimaryKey(CollectionArticle record);
}