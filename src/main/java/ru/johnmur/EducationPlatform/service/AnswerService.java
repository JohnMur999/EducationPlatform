package ru.johnmur.EducationPlatform.service;

import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerMapper;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerRequestDTO;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerResponseDTO;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.AnswerRepository;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;
import ru.johnmur.EducationPlatform.repository.UserRepository;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper, UserRepository userRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    public AnswerResponseDTO save(AnswerRequestDTO answerRequestDTO) {
        Question question = questionRepository.findById()
    }

}
