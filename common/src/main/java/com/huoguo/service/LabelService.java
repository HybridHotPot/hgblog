package com.huoguo.service;

import com.huoguo.bean.Label;
import com.huoguo.dao.LabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LabelService {
    @Autowired
    private LabelMapper labelMapper;

    public ArrayList<Label> findAll() {
        return labelMapper.findAll();
    }
}
