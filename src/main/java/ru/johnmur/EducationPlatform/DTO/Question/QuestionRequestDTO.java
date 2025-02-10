package ru.johnmur.EducationPlatform.DTO.Question;

public class QuestionRequestDTO {
    private String topic;
    private String title;
    private String body;
    private String author;

    public QuestionRequestDTO() {}

    public QuestionRequestDTO(String topic, String title, String body, String author) {
        this.topic = topic;
        this.title = title;
        this.body = body;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

