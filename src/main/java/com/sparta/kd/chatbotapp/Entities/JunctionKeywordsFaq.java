package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "junction_keywords_faqs", schema = "chatbot_db")
public class JunctionKeywordsFaq {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "keyword_id", nullable = false)
    private Keyword keyword;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Faq question;

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }

    public Faq getQuestion() {
        return question;
    }

    public void setQuestion(Faq question) {
        this.question = question;
    }

}