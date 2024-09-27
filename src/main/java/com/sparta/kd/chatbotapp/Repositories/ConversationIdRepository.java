package com.sparta.kd.chatbotapp.Repositories;

import com.sparta.kd.chatbotapp.Entities.ConversationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationIdRepository extends JpaRepository<ConversationId, Integer> {
}
