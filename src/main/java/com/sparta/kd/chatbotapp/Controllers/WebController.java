package com.sparta.kd.chatbotapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/chatbot")
public class WebController {

    @GetMapping
    public String getHome() {
        return "home";
    }



}
