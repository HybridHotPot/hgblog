package com.huoguo.dao;

import com.huoguo.bean.MergeArticleLabel;

public interface MergeArticleLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MergeArticleLabel record);

    int insertSelective(MergeArticleLabel record);

    MergeArticleLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MergeArticleLabel record);

    int updateByPrimaryKey(MergeArticleLabel record);
}