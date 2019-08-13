package com.py.myweb.mapper;

import com.py.myweb.domain.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmtcreat,gmtmodified,creator,tag)" +
            "values (#{title},#{description},#{gmtcreat},#{gmtmodified},#{creator},#{tag})")
    void creat(Question question);

    @Select("select * from question")
    List<Question> list();

    @Select("select count(1) from question")
    Integer count();
}
