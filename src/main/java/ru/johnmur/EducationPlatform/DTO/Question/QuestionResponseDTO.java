package ru.johnmur.EducationPlatform.DTO.Question;

import ru.johnmur.EducationPlatform.DTO.Answer.AnswerResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionResponseDTO {
    private Long id;
    private String topic;
    private String title;
    private String body;
    private Integer rating;
    private String author;
    private LocalDateTime createdAt;
    private List<AnswerResponseDTO> answers;

    public QuestionResponseDTO() {}

    public QuestionResponseDTO(Long id, String topic, String title, String body, Integer rating, String author, LocalDateTime createdAt, List<AnswerResponseDTO> answers) {
        this.id = id;
        this.topic = topic;
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.author = author;
        this.createdAt = createdAt;
        this.answers = answers;
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

    public List<AnswerResponseDTO> getAnswers() {
        return answers;
    }
}

