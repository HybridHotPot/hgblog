package com.huoguo.dao;

import com.huoguo.bean.Follow;

public interface FollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    //通过用户id 得到该用户关注的人数
    int getFollowNumber(Integer uid);
}