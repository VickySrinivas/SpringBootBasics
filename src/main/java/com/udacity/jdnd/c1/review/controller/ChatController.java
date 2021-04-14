package com.udacity.jdnd.c1.review.controller;

import com.udacity.jdnd.c1.review.model.ChatForm;
import com.udacity.jdnd.c1.review.service.MessageService;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/chat")
    public String getChatWindow(Authentication authentication, @ModelAttribute("chatForm") ChatForm chatForm, Model m){
        m.addAttribute("chatMessages", this.messageService.getChatMessages(authentication.getName()))   ;
        return "chat";
    }

    @PostMapping("/chat")
    public String addChat(Authentication authentication, @ModelAttribute("chatForm") ChatForm chatForm, Model m){
        chatForm.setUsername(authentication.getName());
        this.messageService.setChatMessages(chatForm);
//        chatForm.setMessageText("");
        m.addAttribute("chatMessages", this.messageService.getChatMessages(authentication.getName()));
//        chatForm.setUsername("");

        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes(){
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
