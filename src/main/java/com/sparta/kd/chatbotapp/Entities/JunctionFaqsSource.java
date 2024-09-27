package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "junction_faqs_sources", schema = "chatbot_db")
public class JunctionFaqsSource {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Faq question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

    public Faq getQuestion() {
        return question;
    }

    public void setQuestion(Faq question) {
        this.question = question;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

}