package ru.johnmur.EducationPlatform.DTO.Answer;

public class AnswerRequestDTO {
    private Long questionId;
    private String content;
    private String author;

    public AnswerRequestDTO() {}

    public AnswerRequestDTO(Long questionId, String content, String author) {
        this.questionId = questionId;
        this.content = content;
        this.author = author;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

