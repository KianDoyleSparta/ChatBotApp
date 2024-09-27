package com.sparta.kd.chatbotapp.Repositories;

import com.sparta.kd.chatbotapp.Entities.JunctionKeywordsFaq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JunctionKeywordsFaqRepository extends JpaRepository<JunctionKeywordsFaq, JunctionKeywordsFaq> {
}
