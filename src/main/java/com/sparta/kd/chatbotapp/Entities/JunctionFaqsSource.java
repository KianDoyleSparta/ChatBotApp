package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "junction_faqs_sources", schema = "chatbot_db")
public class JunctionFaqsSource {

    @EmbeddedId
    private JunctionFaqsSourceId id;  // Composite key

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("questionId") // Use the field name from the embedded ID class
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false) // Make sure "id" is the primary key column in the Faq entity
    private Faq question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("sourceId") // Use the field name from the embedded ID class
    @JoinColumn(name = "source_id", referencedColumnName = "source_id", nullable = false) // Make sure "id" is the primary key column in the Source entity
    private Source source;

    // Getters and Setters
    public JunctionFaqsSourceId getId() {
        return id;
    }

    public void setId(JunctionFaqsSourceId id) {
        this.id = id;
    }

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
