package com.py.myweb.service;

import com.py.myweb.domain.Page;
import com.py.myweb.domain.Question;
import com.py.myweb.domain.User;
import com.py.myweb.dto.QuestionDTO;
import com.py.myweb.mapper.QuestionMapper;
import com.py.myweb.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list(Integer page) {


        List<Question> qusetions = questionMapper.list(page);
        List<QuestionDTO> questionDTOList=new ArrayList<>();

        for (Question question : qusetions) {
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        return questionDTOList;
    }
}
