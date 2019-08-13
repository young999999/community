package com.py.myweb.mapper;

import com.py.myweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Select("select * from area where id=#{id}")
    public User getUserById(Integer id);

    @Insert("insert into user (name,accountID,token,gmtCreat,gmtModified,avatarurl) " +
            "values (#{name},#{accountID},#{token},#{gmtCreat},#{gmtModified},#{avatarurl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    //如果参数是一个类，不用加@Param
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
}
