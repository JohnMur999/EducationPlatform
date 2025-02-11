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

import java.util.List;

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
        Answer answer = answerMapper.toEntity(dto);
        answer = answerRepository.save(answer);
        return answerMapper.toResponse(answer);
    }

    public AnswerResponseDTO findById(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found with id: " + id));
        return answerMapper.toResponse(answer);
    }

    public List<AnswerResponseDTO> findByQuestionId(Long questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);
        return answers.stream().map(answerMapper::toResponse).toList();
    }

}
