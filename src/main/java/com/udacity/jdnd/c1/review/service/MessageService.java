package com.udacity.jdnd.c1.review.service;

import com.udacity.jdnd.c1.review.mapper.MessageMapper;
import com.udacity.jdnd.c1.review.model.ChatForm;
import com.udacity.jdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
//    private List<ChatMessage> chatMessages;
   /* public List<ChatMessage> getChatMessages() {
        return this.chatMessages;
    }*/

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService Bean");
    }

    public List<ChatMessage> getChatMessages(String username) {

        return this.messageMapper.getMessage(username);
    }

    public void setChatMessages(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case "Say" :  newMessage.setMessage(chatForm.getMessageText());
            break;
            case "Shout": newMessage.setMessage(chatForm.getMessageText().toUpperCase());
            break;
            case "Whisper": newMessage.setMessage(chatForm.getMessageText().toLowerCase());
            break;
        }
//        this.chatMessages.add(newMessage);
          messageMapper.insertMessage(newMessage);

    }

}

