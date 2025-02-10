package ru.johnmur.EducationPlatform.repository;

import org.springframework.stereotype.Repository;
import ru.johnmur.EducationPlatform.model.Answer;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository {
    Optional<Answer> findById(Long id);
    Optional<Answer> findByAuthor(String author);
}
