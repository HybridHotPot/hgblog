package com.huoguo.facade.controller;

import com.alibaba.fastjson.JSON;
import com.huoguo.JsonBean.ArticleDetail;
import com.huoguo.JsonBean.ArticleRecommend;
import com.huoguo.bean.Article;
import com.huoguo.bean.CarouselArticle;
import com.huoguo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 文章推荐
     * @param index 页号，每页加载4篇文章，第一页加载7篇,index从1开始
     * @return
     */
    @RequestMapping(value = "/recommends/{index}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String articleRecommends(@PathVariable(value = "index") int index){
        ArrayList<ArticleRecommend> list=articleService.findArticleRecommend(index);
        return JSON.toJSONString(list);
    }

    /**
     * 主页的【点击排行】【最新文章】【站长推荐】
     * @return
     */
    @RequestMapping(value = "/click_new_recommend",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String click_new_recommend(){
        Map<String,Object> map=new HashMap<>();
        ArrayList<String> clicks=new ArrayList<>();//点击量最多的几个文章,存放标题和id
        ArrayList<String> newArticles=new ArrayList<>();//最新的几个文章,存放标题和id
        ArrayList<String> recommends=new ArrayList<>();//最新的几个文章,存放标题和id
        ArrayList<Article> articles=articleService.findTopClicks();
        for(Article e:articles)
            clicks.add(e.getTitle()+";"+e.getId());
        articles=articleService.findTopNew();
        for(Article e:articles)
            newArticles.add(e.getTitle()+";"+e.getId());
        articles=articleService.findTopRecommend();
        for (Article e:articles)
            recommends.add(e.getTitle()+";"+e.getId());

        map.put("点击排行",clicks);
        map.put("最新文章",newArticles);
        map.put("站长推荐",recommends);
        return JSON.toJSONString(map);
    }

    /**
     * 这只是一个中间跳转的controller，并没有查询数据
     */
    @RequestMapping(value = {"/detail/{title}/{articleId}/{label}/{articlecategory}/{time}/{pv}","/detail/{articleId}"},method = RequestMethod.GET)
    public String articleDetail(@PathVariable(value = "articleId") int articleId,
                                @PathVariable(value ="label",required = false) String label,
                                @PathVariable(value = "articlecategory",required = false) String articlecategory,
                                @PathVariable(value = "time",required = false) String time,
                                @PathVariable(value = "pv",required = false) String pv,
                                @PathVariable(value = "title",required = false)String title){
        if(label==null||label.equals(""))
            return "a";//如果没有传来标签，说明还需要自己到数据库查询标签 时间 访问量
        return "articleDeatil";
    }

    @RequestMapping(value = "/carousel",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String carouselArticle(){
        ArrayList<CarouselArticle> list=articleService.findCarouselArticles();
        return JSON.toJSONString(list);
    }

    /**
     * 显示文章内容，包括标签 访问量之类的
     * @param
     * @return
     */
    @GetMapping(value = "/getArticleSubject/{title}/{id}/{label}/{category}/{time}/{pv}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getArticleSubject(@PathVariable(value = "id")String id,@PathVariable(value = "label")String label,
                                    @PathVariable(value = "category")String category,@PathVariable(value = "time")String time,
                                    @PathVariable(value = "pv")String pv,@PathVariable(value = "title") String title){
        String article=articleService.find(id);
        String[] labels=label.split(",");
        String[] categorys=category.split(",");
        ArticleDetail articleDetail=new ArticleDetail(title,labels,categorys,time,pv,article);
        return JSON.toJSONString(articleDetail);
    }
}
