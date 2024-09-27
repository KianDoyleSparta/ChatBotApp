package com.sparta.kd.chatbotapp.Repositories;

import com.sparta.kd.chatbotapp.Entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
}
