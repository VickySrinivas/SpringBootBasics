package com.udacity.jdnd.c1.review.controller;

import com.udacity.jdnd.c1.review.model.User;
import com.udacity.jdnd.c1.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserService userService;
    public SignUpController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String signUpView(){
        return "signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute User user, Model model) {
        String signupError = null;
        if(! userService.isUsernameAvailable(user.getUsername())){
            signupError = "The username already exists.";
        }

        if(signupError == null){
            int rowsAdded = userService.createUser(user);
            if(rowsAdded == 0){
                signupError = "There was an error signing you up. Please try again.";
            }
        }
        if (signupError == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signupError);
        }
        return "signup";
    }
}
