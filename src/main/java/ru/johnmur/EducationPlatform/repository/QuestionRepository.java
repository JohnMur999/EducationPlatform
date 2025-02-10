package ru.johnmur.EducationPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.johnmur.EducationPlatform.model.Question;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findById(Long id);
    Optional<Question> findByTitle(String title);
}
