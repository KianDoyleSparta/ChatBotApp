package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JunctionKeywordsFaqId implements Serializable {

    private Long keywordId; // Field names must match with @MapsId("keywordId") in the entity
    private Long questionId; // Field names must match with @MapsId("questionId") in the entity

    public JunctionKeywordsFaqId() {
    }

    public JunctionKeywordsFaqId(Long keywordId, Long questionId) {
        this.keywordId = keywordId;
        this.questionId = questionId;
    }

    // Getters and Setters

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JunctionKeywordsFaqId)) return false;
        JunctionKeywordsFaqId that = (JunctionKeywordsFaqId) o;
        return Objects.equals(keywordId, that.keywordId) &&
                Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordId, questionId);
    }
}
