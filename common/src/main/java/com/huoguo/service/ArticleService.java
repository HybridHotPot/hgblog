package com.huoguo.service;

import com.huoguo.JsonBean.ArticleRecommend;
import com.huoguo.bean.Article;
import com.huoguo.bean.CarouselArticle;
import com.huoguo.bean.Label;
import com.huoguo.dao.*;
import com.huoguo.util.MyApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;
    @Autowired
    private CarouselArticleMapper carouselArticleMapper;

    /**
     * 返回第index页的推荐文章
     * @param index
     * @return
     */
    public ArrayList<ArticleRecommend> findArticleRecommend(int index) {
        ArrayList<Article> articles;//所有文章
        ArrayList<String> alllabels=new ArrayList<>();//文章的标签
        ArrayList<Integer> commentNumber=new ArrayList<>();//每篇文章的评论数
        ArrayList<ArticleRecommend> list=new ArrayList<>();//打包数据

        int perNumber=MyApplication.ArticleRecommendPerNumber;
        //取文章
        if(index==1)
            articles=articleMapper.findRecommend(0,MyApplication.ArticleRecommendFirst);
        else
            articles=articleMapper.findRecommend((index-1)* perNumber,index*perNumber);

        for(Article e:articles){
            //取每篇文章的标签1，标签2..
            String tmp="";
            int tmpnumber;
            ArrayList<String> articleLabels=labelMapper.findLabelsByArticle(e.getId());
            for(String s:articleLabels)
                tmp+=s+";";
            alllabels.add(tmp);
            //取每篇文章对应的评论数
            tmpnumber=commentMapper.findNumberByArticle(e.getId());
            commentNumber.add(tmpnumber);
            //将文章分类id转换成文章分类
            String articlecategory=articleCategoryMapper.findName(e.getArticlecategoryId());
            //打包数据
            ArticleRecommend articleRecommend=new ArticleRecommend(e,tmp,tmpnumber,articlecategory);
            list.add(articleRecommend);
        }
        return list;
    }

    /**
     * 找到访问量最高的几篇文章
     * @return
     */
    public ArrayList<Article> findTopClicks() {
        return articleMapper.findTopClick(MyApplication.ClickNewRecommend);
    }

    /**
     * 找到最新的几篇文章
     * @return
     */
    public ArrayList<Article> findTopNew() {
        return articleMapper.findTopNew(MyApplication.ClickNewRecommend);
    }

    /**
     * 找到管理员推荐的文章，isRecommend数值越大，优先级越高
     * @return
     */
    public ArrayList<Article> findTopRecommend() {
        return articleMapper.findTopRecommend(MyApplication.ClickNewRecommend);
    }

    public ArrayList<CarouselArticle> findCarouselArticles() {
        return carouselArticleMapper.findAll();
    }

    /**
     * 根据文章id获得文章的主要内容
     * @param id
     * @return
     */
    public String find(String id) {
        return articleMapper.find(id);
    }
}
