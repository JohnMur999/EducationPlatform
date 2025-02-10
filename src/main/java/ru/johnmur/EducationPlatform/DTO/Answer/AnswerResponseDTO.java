package ru.johnmur.EducationPlatform.DTO.Answer;

import java.time.LocalDateTime;

public class AnswerResponseDTO {
    private Long id;
    private Long questionId;
    private String content;
    private Long authorId;
    private LocalDateTime createdAt;

    public AnswerResponseDTO() {}

    public AnswerResponseDTO(Long id, Long questionId, String content, Long authorId, LocalDateTime createdAt) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getContent() {
        return content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
