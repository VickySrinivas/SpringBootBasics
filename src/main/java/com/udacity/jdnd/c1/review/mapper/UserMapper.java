package com.udacity.jdnd.c1.review.mapper;

import com.udacity.jdnd.c1.review.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

@Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES(#{username}, #{salt}, #{password}," +
        "#{firstname}, #{lastname})")
@Options(useGeneratedKeys = true, keyProperty = "userid")
int addUser(User user);

@Select("SELECT * FROM USERS WHERE username = #{username}")
User getUser(String username);

}
