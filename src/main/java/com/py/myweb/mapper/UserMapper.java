package com.py.myweb.mapper;

import com.py.myweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Select("select * from area where id=#{id}")
    public User getUserById(Integer id);

    @Insert("insert into user (name,accountID,token,gmtCreat,gmtModified) " +
            "values (#{name},#{accountID},#{token},#{gmtCreat},#{gmtModified})")
    void insert(User user);
}
