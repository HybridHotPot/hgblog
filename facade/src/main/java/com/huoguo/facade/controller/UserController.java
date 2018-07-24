package com.huoguo.facade.controller;

import com.alibaba.fastjson.JSON;
import com.huoguo.JsonBean.PersonalData;
import com.huoguo.JsonBean.PrivateCategory;
import com.huoguo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 通过文章id获得博主的个人信息
     * @param articleId
     * @return
     */
    @GetMapping(value = "/getPersonalData/{id}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getPersonalData(@PathVariable(value = "id")String articleId){
        PersonalData personalData=userService.getPersonalDataByArticle(articleId);
        return JSON.toJSONString(personalData);
    }

    @GetMapping(value = "/getPrivateCategory/{id}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getPrivateCategory(@PathVariable(value = "id")Integer uid){
        ArrayList<PrivateCategory> privateCategories=userService.getCategoryInfo(uid);
        return JSON.toJSONString(privateCategories);
    }
}
