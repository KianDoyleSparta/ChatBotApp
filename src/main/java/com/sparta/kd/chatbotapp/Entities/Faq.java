package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "faqs", schema = "chatbot_db")
public class Faq {
    @Id
    @Column(name = "question_id", nullable = false)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Lob
    @Column(name = "answer", nullable = false)
    private String answer;

    @ManyToMany
    @JoinTable(name = "junction_faqs_sources",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "source_id"))
    private Set<Source> sources = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "junction_keywords_faqs",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<Source> getSources() {
        return sources;
    }

    public void setSources(Set<Source> sources) {
        this.sources = sources;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

}