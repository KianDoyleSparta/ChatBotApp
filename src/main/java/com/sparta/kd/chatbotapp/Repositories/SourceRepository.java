package com.sparta.kd.chatbotapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<SourceRepository, Integer> {
}
