package com.sparta.kd.chatbotapp.Services;

import com.sparta.kd.chatbotapp.Entities.ConversationHistory;
import com.sparta.kd.chatbotapp.Entities.ConversationHistoryId;
import com.sparta.kd.chatbotapp.Repositories.ConversationHistoryRepository;
import com.sparta.kd.chatbotapp.Repositories.ConversationIdRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
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
            return 1;
        } else {
            Long incrementedCount = conversationIdRepository.count() + 1;
            return incrementedCount.intValue();
        }
    }

    public List<ConversationHistory> getCurrentConversationById(Integer id) {
        ConversationHistoryId conversationHistoryId = new ConversationHistoryId();
        conversationHistoryId.setConversationId(id);

        ConversationHistory conversationHistory = new ConversationHistory();
        conversationHistory.setId(conversationHistoryId);

        Example<ConversationHistory> example = Example.of(conversationHistory);

        return conversationHistoryRepository.findAll(example);
    }

    public void updateCurrentConversationById(Integer id, String input, String response) {
        ConversationHistoryId conversationHistoryId = new ConversationHistoryId();
        conversationHistoryId.setConversationId(id);
        conversationHistoryId.setCreatedAt(Instant.from(LocalDateTime.now()));

        ConversationHistory conversationHistory = new ConversationHistory();
        conversationHistory.setId(conversationHistoryId);
        conversationHistory.setInput(input);
        conversationHistory.setResponse(response);

        conversationHistoryRepository.save(conversationHistory);
    }

}
