package com.huoguo.dao;

import com.huoguo.bean.Label;

import java.util.ArrayList;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);

    //查询文章的所有标签
    ArrayList<String> findLabelsByArticle(Integer articleId);

    ArrayList<Label> findAll();
}