package com.sparta.kd.chatbotapp.Utilities;

import com.sparta.kd.chatbotapp.Entities.Faq;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResponseFormatter {

    public String formatFaqResponse(ArrayList<Faq> response) {
        if (response.isEmpty()) {
            return "I'm sorry, I couldn't quite find the answer in our database. Could you please be more specific?";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Faq faq : response) {
                sb.append(faq.getAnswer()).append("\n");
            }
            return "I found some related common FAQs. " + sb.toString() + " Did these help answer your question? (Yes/No)";
        }
    }
}
