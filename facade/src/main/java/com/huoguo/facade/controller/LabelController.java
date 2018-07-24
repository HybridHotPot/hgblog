package com.huoguo.facade.controller;

import com.alibaba.fastjson.JSON;
import com.huoguo.bean.Label;
import com.huoguo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;

@Controller
@RequestMapping(value = "/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 加载主页的标签云
     * @return
     */
    @RequestMapping(value = "/cloud",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String labelCloud(){
        ArrayList<Label> labels=labelService.findAll();
        HashSet<Label> set=new HashSet<>(labels);//用hashset打乱  顺序
        return JSON.toJSONString(set);
    }

    /**
     * 显示该标签下的文章
     * @param index
     * @return
     */
    @RequestMapping(value = "/article/{index}/{label}",method = RequestMethod.GET)
    public String labelArticle(@PathVariable(value = "index") int index, @PathVariable(value = "label") String label){
        System.out.println(index+";"+label);
        return "/";
    }
}
