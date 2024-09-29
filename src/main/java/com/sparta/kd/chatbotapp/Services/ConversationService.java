package com.sparta.kd.chatbotapp.Services;

import com.sparta.kd.chatbotapp.Entities.ConversationHistory;
import com.sparta.kd.chatbotapp.Entities.ConversationHistoryId;
import com.sparta.kd.chatbotapp.Entities.ConversationId;
import com.sparta.kd.chatbotapp.Repositories.ConversationHistoryRepository;
import com.sparta.kd.chatbotapp.Repositories.ConversationIdRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ConversationService {

    private final ConversationIdRepository conversationIdRepository;
    private final ConversationHistoryRepository conversationHistoryRepository;

    public ConversationService(ConversationIdRepository conversationIdRepository, ConversationHistoryRepository conversationHistoryRepository) {
        this.conversationIdRepository = conversationIdRepository;
        this.conversationHistoryRepository = conversationHistoryRepository;
    }

    public Integer getNewConversationId() {
        if (conversationIdRepository.count() == 0) {
            ConversationId conversationId = new ConversationId();
            conversationId.setId(1);
            conversationIdRepository.save(conversationId);
            return 1;
        } else {
            Long incrementedCount = conversationIdRepository.count() + 1;
            ConversationId conversationId = new ConversationId();
            conversationId.setId(incrementedCount.intValue());
            conversationIdRepository.save(conversationId);
            return incrementedCount.intValue();
        }
    }

    public List<ConversationHistory> getCurrentConversationById(Integer id) {
        ArrayList<ConversationHistory> histories = new ArrayList<>(conversationIdRepository.getReferenceById(id).getConversationHistories());
        histories.sort(new Comparator<ConversationHistory>() {
            @Override
            public int compare(ConversationHistory c1, ConversationHistory c2) {
                return c1.getId().getCreatedAt().compareTo(c2.getId().getCreatedAt());
            }
        });

        return histories;
    }

    public void updateCurrentConversationById(Integer id, String input, String response) {
        ConversationId conversationId = conversationIdRepository.getReferenceById(id);

        ConversationHistoryId conversationHistoryId = new ConversationHistoryId();
        conversationHistoryId.setConversationId(id);
        conversationHistoryId.setCreatedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC));

        ConversationHistory conversationHistory = new ConversationHistory();
        conversationHistory.setConversation(conversationId);
        conversationHistory.setId(conversationHistoryId);
        conversationHistory.setInput(input);
        conversationHistory.setResponse(response);

        conversationHistoryRepository.save(conversationHistory);
    }

}
