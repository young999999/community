package com.py.myweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.py.myweb.dto.QuestionDTO;
import com.py.myweb.mapper.UserMapper;
import com.py.myweb.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MywebApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @Test
    public void test(){
        List<QuestionDTO> questionList=questionService.list();
        System.out.println(questionList);

        String jsonstring=JSON.toJSONString(questionList);
        System.out.println(jsonstring);

        JSONArray jsonparse = JSONArray.parseArray(jsonstring);
        System.out.println(jsonparse.get(1));
    }

}
