package com.udacity.jdnd.c1.review.mapper;

import com.udacity.jdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

@Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
@Options(useGeneratedKeys = true, keyProperty = "messageid")
int insertMessage(ChatMessage chatMessage);

@Select("SELECT * FROM MESSAGES WHERE username = #{username}")
List<ChatMessage> getMessage(String username);

}
