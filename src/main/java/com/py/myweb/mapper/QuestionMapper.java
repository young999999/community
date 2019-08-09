package com.py.myweb.mapper;

import com.py.myweb.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionMapper {

    @Select("insert into question (title,description,gmtcreat,gmtmodified,creator,tag)" +
            "values (#{title},#{description},#{gmtcreat},#{gmtmodified},#{creator},#{tag})")
    void creat(Question question);
}
