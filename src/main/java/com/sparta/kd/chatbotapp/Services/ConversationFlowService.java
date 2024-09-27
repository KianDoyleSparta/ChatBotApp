package com.sparta.kd.chatbotapp.Services;

import org.springframework.stereotype.Service;

@Service
public class ConversationFlowService {
    public String getStartMessage() {
        return "Hello, I'm SpartaBot, how can I help you today?";
    }
}
