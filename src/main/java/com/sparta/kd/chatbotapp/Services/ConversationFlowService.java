package com.sparta.kd.chatbotapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationFlowService {

    private final ConversationService conversationService;
    private final FaqService faqService;

    public ConversationFlowService(ConversationService conversationService, FaqService faqService) {
        this.conversationService = conversationService;
        this.faqService = faqService;
    }

    public String getStartMessage() {
        return "Hello, I'm SpartaBot, how can I help you today?";
    }
}
