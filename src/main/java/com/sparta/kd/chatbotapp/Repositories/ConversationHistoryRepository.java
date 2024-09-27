package com.sparta.kd.chatbotapp.Repositories;

import com.sparta.kd.chatbotapp.Entities.ConversationHistory;
import com.sparta.kd.chatbotapp.Entities.ConversationHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationHistoryRepository extends JpaRepository<ConversationHistory, ConversationHistoryId> {
}