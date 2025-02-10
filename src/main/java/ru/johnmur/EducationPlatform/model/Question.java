package ru.johnmur.EducationPlatform.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer rating = 0;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Question() {}

    public Question(Long id, String topic, String title, String body, Integer rating, String author, LocalDateTime createdAt) {
        this.id = id;
        this.topic = topic;
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.author = author;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
