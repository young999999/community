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
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;


    @ResponseBody
    @RequestMapping("/index")
    public /*List<QuestionDTO>*/ Object index(HttpServletRequest request,
                                             @RequestBody Page page){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null&&cookies.length!=0)
            for (Cookie cookie:cookies
                 ) {
                if (cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user=userMapper.findByToken(token);
                    if (user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        System.out.println(page.getPage());
        List<QuestionDTO> questionList=questionService.list();

        //model.addAttribute("questions",questionList);
        System.out.println(JSON.toJSONString(questionList.get(0)));
        return JSON.toJSONString(questionList.get(0));
    }

    @RequestMapping("/index1")
    public String index1(@RequestBody Page page,
                         Model model){
        System.out.println(page.getPage());
        return "redirect:/index";
    }
}
