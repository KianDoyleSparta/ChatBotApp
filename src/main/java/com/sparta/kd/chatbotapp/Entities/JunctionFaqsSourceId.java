package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JunctionFaqsSourceId implements Serializable {

    private Long questionId;
    private Long sourceId;

    // Default constructor
    public JunctionFaqsSourceId() {
    }

    // Parameterized constructor
    public JunctionFaqsSourceId(Long questionId, Long sourceId) {
        this.questionId = questionId;
        this.sourceId = sourceId;
    }

    // Getters and Setters
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    // Equals and hashCode for primary key class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JunctionFaqsSourceId)) return false;
        JunctionFaqsSourceId that = (JunctionFaqsSourceId) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(sourceId, that.sourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, sourceId);
    }
}
