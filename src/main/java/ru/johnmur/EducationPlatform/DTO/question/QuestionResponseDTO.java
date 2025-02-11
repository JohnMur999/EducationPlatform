package ru.johnmur.EducationPlatform.DTO.question;

import ru.johnmur.EducationPlatform.DTO.answer.AnswerResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionResponseDTO {
    private Long id;
    private String topic;
    private String title;
    private String body;
    private Integer rating;
    private Long authorId;
    private LocalDateTime createdAt;
    private List<AnswerResponseDTO> answers;

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<AnswerResponseDTO> getAnswers() { return answers; }
    public void setAnswers(List<AnswerResponseDTO> answers) { this.answers = answers; }
}
