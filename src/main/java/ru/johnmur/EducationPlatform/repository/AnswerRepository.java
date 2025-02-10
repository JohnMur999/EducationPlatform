package ru.johnmur.EducationPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.johnmur.EducationPlatform.model.Answer;
import ru.johnmur.EducationPlatform.model.User;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Optional<Answer> findById(Long id);
    Optional<Answer> findByAuthor(User author);
    Answer save(Answer answer);
}
