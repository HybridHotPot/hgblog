package com.huoguo.facade.controller;

import com.huoguo.JsonBean.JsonComments;
import com.huoguo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //页数下标从1开始
    @GetMapping(value = {"/get/{articleId}/{index}","/get/{articleId}"})
    public String getComment(@PathVariable(value = "articleId")int articleId,
                             @PathVariable(value = "index",required = false)Integer page_index){
        if(page_index==null)
            page_index=1;
        ArrayList<JsonComments> list=commentService.findComments(articleId,page_index.intValue());
        return "";
    }
}
