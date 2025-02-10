package ru.johnmur.EducationPlatform.DTO.question;

public class QuestionRequestDTO {
    private String topic;
    private String title;
    private String body;
    private Long authorId;

    public QuestionRequestDTO() {}

    public QuestionRequestDTO(String topic, String title, String body, Long authorId) {
        this.topic = topic;
        this.title = title;
        this.body = body;
        this.authorId = authorId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}

