package ru.johnmur.EducationPlatform.DTO.Answer;

import java.time.LocalDateTime;

public class AnswerResponseDTO {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public AnswerResponseDTO() {}

    public AnswerResponseDTO(Long id, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

