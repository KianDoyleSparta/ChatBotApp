package com.sparta.kd.chatbotapp.Entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sources", schema = "chatbot_db")
public class Source {
    @Id
    @Column(name = "source_id", nullable = false)
    private Integer id;

    @Column(name = "source_title", nullable = false)
    private String sourceTitle;

    @Column(name = "source_link", nullable = false, length = 2048)
    private String sourceLink;

    @ManyToMany(mappedBy = "sources")
    private Set<Faq> faqs = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceTitle() {
        return sourceTitle;
    }

    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public Set<Faq> getFaqs() {
        return faqs;
    }

    public void setFaqs(Set<Faq> faqs) {
        this.faqs = faqs;
    }

}