package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "junction_keywords_faqs", schema = "chatbot_db")
public class JunctionKeywordsFaq {

    @EmbeddedId
    private JunctionKeywordsFaqId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("keywordId") // This must match the field name in the composite key class
    @JoinColumn(name = "keyword_id", referencedColumnName = "keyword_id", nullable = false) // Ensure 'name' matches the database column
    private Keyword keyword;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("questionId") // This must match the field name in the composite key class
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false) // Ensure 'name' matches the database column
    private Faq question;

    // Getters and Setters

    public JunctionKeywordsFaqId getId() {
        return id;
    }

    public void setId(JunctionKeywordsFaqId id) {
        this.id = id;
    }

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
