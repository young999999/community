package com.py.myweb.service;

import com.py.myweb.domain.Question;
import com.py.myweb.domain.User;
import com.py.myweb.dto.PaginationDTO;
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

    public PaginationDTO list(Integer page, Integer size) {

        Integer offset =size*(page-1);

        List<Question> qusetions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : qusetions) {
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }
}
