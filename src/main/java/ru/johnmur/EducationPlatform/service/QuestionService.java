package ru.johnmur.EducationPlatform.service;

import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.DTO.question.QuestionMapper;
import ru.johnmur.EducationPlatform.DTO.question.QuestionRequestDTO;
import ru.johnmur.EducationPlatform.DTO.question.QuestionResponseDTO;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    public QuestionResponseDTO save(QuestionRequestDTO dto) {
        Question question = questionMapper.toEntity(dto);
        question = questionRepository.save(question);
        return questionMapper.toResponse(question);
    }

    public List<QuestionResponseDTO> findAll() {
        return questionRepository.findAll().stream()
                .map(questionMapper::toResponse)
                .collect(Collectors.toList());
    }
}
