package com.sparta.kd.chatbotapp.Repositories;

import com.sparta.kd.chatbotapp.Entities.JunctionFaqsSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JunctionFaqSourceRepository extends JpaRepository<JunctionFaqsSource, JunctionFaqsSource> {
}
