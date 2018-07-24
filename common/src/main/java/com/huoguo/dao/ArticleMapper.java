package com.huoguo.dao;

import com.huoguo.bean.Article;

import java.util.ArrayList;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    ArrayList<Article> findRecommend(int i, int i1);

    ArrayList<Article> findTopClick(int limit);

    ArrayList<Article> findTopNew(int limit);

    ArrayList<Article> findTopRecommend(int limit);

    String find(String id);

    int getUidByAid(int id);

    int findArticleNumByCategory(Integer categoryId);
}