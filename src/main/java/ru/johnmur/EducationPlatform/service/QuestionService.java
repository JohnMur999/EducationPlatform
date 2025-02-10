package ru.johnmur.EducationPlatform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    Logger logger = LoggerFactory.getLogger(QuestionService.class);

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question) {
        logger.info("[SERVICE METHOD] Saving question: " + question);
        return questionRepository.save(question);
    }

    public Question findById(Long id) {
        logger.info("[SERVICE METHOD] Finding question by id: " + id);
        Question question =  questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        return question;
    }

    public Question findByTitle(String title) {
        logger.info("[SERVICE METHOD] Finding question by title: " + title);

        Question question = questionRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Questing with title " + title + " not found"));

        return question;
    }

    public List<Question> findAll() {
        logger.info("[SERVICE METHOD] Finding all questions");

        List<Question> questions = questionRepository.findAll();
        return questions;
    }
}
