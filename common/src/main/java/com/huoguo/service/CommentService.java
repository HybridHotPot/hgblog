package com.huoguo.service;

import com.huoguo.JsonBean.JsonComments;
import com.huoguo.dao.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public ArrayList<JsonComments> findComments(int articleId, int page_index) {

    }
}
