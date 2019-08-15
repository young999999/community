package com.py.myweb.controller;

import com.alibaba.fastjson.JSON;
import com.py.myweb.domain.Page;
import com.py.myweb.domain.User;
import com.py.myweb.dto.QuestionDTO;
import com.py.myweb.mapper.UserMapper;
import com.py.myweb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;


    @ResponseBody
    @RequestMapping("/index")
    public /*List<QuestionDTO>*/ Object index(HttpServletRequest request,
                                             @RequestBody Page page){

        System.out.println(page.getPage());
        List<QuestionDTO> questionList=questionService.list(page.getPage()*4);

        return JSON.toJSONString(questionList);
    }
}
