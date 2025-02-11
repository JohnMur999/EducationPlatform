package ru.johnmur.EducationPlatform.DTO.user;

import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;
import ru.johnmur.EducationPlatform.repository.UserRepository;

@Component
public class UserMapperHelper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Named("mapAuthor") // Исправляем ошибку Qualifier error
    public User mapAuthor(Long authorId) {
        return userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User with ID " + authorId + " not found"));
    }

    @Named("mapQuestion")
    public Question mapQuestion(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question with ID " + questionId + " not found"));
    }
}


