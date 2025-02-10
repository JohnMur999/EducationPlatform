package ru.johnmur.EducationPlatform.DTO.Answer;

public class AnswerRequestDTO {
    private Long questionId;
    private String content;
    private Long authorId; // Теперь это ID пользователя

    public AnswerRequestDTO() {}

    public AnswerRequestDTO(Long questionId, String content, Long authorId) {
        this.questionId = questionId;
        this.content = content;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
