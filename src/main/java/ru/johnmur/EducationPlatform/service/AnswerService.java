package ru.johnmur.EducationPlatform.service;

import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.DTO.answer.AnswerMapper;
import ru.johnmur.EducationPlatform.DTO.answer.AnswerRequestDTO;
import ru.johnmur.EducationPlatform.DTO.answer.AnswerResponseDTO;
import ru.johnmur.EducationPlatform.model.Answer;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.AnswerRepository;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;
import ru.johnmur.EducationPlatform.repository.UserRepository;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final AnswerMapper answerMapper;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.answerMapper = answerMapper;
    }

    public AnswerResponseDTO save(AnswerRequestDTO dto) {
        Question question = questionRepository.findById(dto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Answer answer = answerMapper.toEntity(dto, question, userRepository);
        answer = answerRepository.save(answer);

        return answerMapper.toResponse(answer);
    }
}
