package com.huoguo.service;

import com.huoguo.JsonBean.PersonalData;
import com.huoguo.JsonBean.PrivateCategory;
import com.huoguo.bean.ArticleCategory;
import com.huoguo.bean.User;
import com.huoguo.dao.ArticleCategoryMapper;
import com.huoguo.dao.ArticleMapper;
import com.huoguo.dao.FollowMapper;
import com.huoguo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private FollowMapper followMapper;
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    public PersonalData getPersonalDataByArticle(String articleId) {
        int uid=articleMapper.getUidByAid(Integer.parseInt(articleId));
        User user=userMapper.selectByPrimaryKey(uid);
        //关注人数，此处可以优化减少一次查询的，将关注人数设计在user表里，懒得改了
        int followNumber=followMapper.getFollowNumber(user.getId());
        PersonalData personalData=new PersonalData(user.getNickname(),user.getPicture(),user.getArticlenumber()
        ,user.getFansnumber(),followNumber);
        return personalData;
    }

    /**
     * 通过用户id得到用户的个人分类，以及每种分类下的文章数量
     * @param uid
     * @return
     */
    public ArrayList<PrivateCategory> getCategoryInfo(Integer uid) {
        ArrayList<ArticleCategory> articleCategories=articleCategoryMapper.findAllByUid(uid);
        ArrayList<Integer> numbers=new ArrayList<>();
        ArrayList<String> names=new ArrayList<>();
        ArrayList<Integer> categoryIds=new ArrayList<>();
        for(ArticleCategory e:articleCategories){
            names.add(e.getName());
            numbers.add(articleMapper.findArticleNumByCategory(e.getId()));
            categoryIds.add(e.getId());
        }
        return PrivateCategory.creatList(categoryIds,names,numbers);
    }
}
