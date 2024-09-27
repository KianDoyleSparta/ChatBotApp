package com.sparta.kd.chatbotapp.Services;

import com.sparta.kd.chatbotapp.Entities.Faq;
import com.sparta.kd.chatbotapp.Entities.Keyword;
import com.sparta.kd.chatbotapp.Repositories.FaqRepository;
import com.sparta.kd.chatbotapp.Repositories.KeywordRepository;
import com.sparta.kd.chatbotapp.Repositories.SourceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Faq> findMatchingFaqs(String userInput) {
        String[] words = userInput.split(" ");
        List<Keyword> keywords = keywordRepository.findAll();
        ArrayList<Keyword> matchedKeywords = new ArrayList<>();

        for (Keyword keyword : keywords) {
            if (Arrays.stream(words).anyMatch(keyword.getKeyword()::contains)) {
                matchedKeywords.add(keyword);
            }
        }

        ArrayList<Faq> matchedFaqs = new ArrayList<>();

        for (Keyword keyword : matchedKeywords) {
            matchedFaqs.addAll(keyword.getFaqs());
        }

        return matchedFaqs;
    }

}
