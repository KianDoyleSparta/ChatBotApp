package com.sparta.kd.chatbotapp.Services;

import com.sparta.kd.chatbotapp.Entities.Source;
import com.sparta.kd.chatbotapp.Repositories.FaqRepository;
import com.sparta.kd.chatbotapp.Repositories.KeywordRepository;
import com.sparta.kd.chatbotapp.Repositories.SourceRepository;
import org.springframework.stereotype.Service;

@Service
public class FaqService {

    private final FaqRepository faqRepository;
    private final KeywordRepository keywordRepository;
    private final SourceRepository sourceRepository;

    public FaqService(FaqRepository faqRepository, KeywordRepository keywordRepository, SourceRepository sourceRepository) {
        this.faqRepository = faqRepository;
        this.keywordRepository = keywordRepository;
        this.sourceRepository = sourceRepository;
    }

    public void findMatchingFaqs(String userInput) {
        
    }

}
