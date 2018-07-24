package com.huoguo.dao;

import com.huoguo.bean.Comment;

import java.util.ArrayList;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    //查询该文章的评论数量
    int findNumberByArticle(Integer articleId);
}