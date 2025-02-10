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
    private Long authorId; // Теперь автор - это ID пользователя
    private LocalDateTime createdAt;
    private List<AnswerResponseDTO> answers = List.of(); // Предотвращаем NPE

    public QuestionResponseDTO() {}

    public QuestionResponseDTO(Long id, String topic, String title, String body, Integer rating, Long authorId, LocalDateTime createdAt, List<AnswerResponseDTO> answers) {
        this.id = id;
        this.topic = topic;
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.authorId = authorId;
        this.createdAt = createdAt;
        this.answers = answers != null ? answers : List.of(); // Безопасная инициализация
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) { // Добавляем сеттер для MapStruct
        this.authorId = authorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<AnswerResponseDTO> getAnswers() {
        return answers;
    }
}
