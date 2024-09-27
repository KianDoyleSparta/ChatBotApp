package com.sparta.kd.chatbotapp.Repositories;

import com.sparta.kd.chatbotapp.Entities.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Integer> {
}
