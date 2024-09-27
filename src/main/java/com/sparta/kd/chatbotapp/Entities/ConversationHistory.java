package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "conversation_history", schema = "chatbot_db")
public class ConversationHistory {
    @EmbeddedId
    private ConversationHistoryId id;

    @MapsId("conversationId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conversation_id", nullable = false)
    private ConversationId conversation;

    @Column(name = "input")
    private String input;

    @Lob
    @Column(name = "response")
    private String response;

    public ConversationHistoryId getId() {
        return id;
    }

    public void setId(ConversationHistoryId id) {
        this.id = id;
    }

    public ConversationId getConversation() {
        return conversation;
    }

    public void setConversation(ConversationId conversation) {
        this.conversation = conversation;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}