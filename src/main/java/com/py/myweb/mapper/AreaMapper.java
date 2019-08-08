package com.py.myweb.mapper;

import com.py.myweb.domain.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AreaMapper {
    @Select("select * from area where id=#{id}")
    public Area getDeptById(Integer id);
}
