package com.udacity.jdnd.c1.review.model;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class ChatMessage {

    private int messageid;
    private String username;
    private String messageText;


    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return messageText;
    }

    public void setMessage(String messageText) {
        this.messageText = messageText;
    }
}
