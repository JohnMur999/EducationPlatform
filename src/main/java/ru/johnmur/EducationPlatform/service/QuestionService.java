package ru.johnmur.EducationPlatform.service;

import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionMapper;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionRequestDTO;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionResponseDTO;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;
import ru.johnmur.EducationPlatform.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, UserRepository userRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.questionMapper = questionMapper;
    }

    public QuestionResponseDTO save(QuestionRequestDTO dto) {
        Question question = questionMapper.toEntity(dto, userRepository);
        question = questionRepository.save(question);
        return questionMapper.toResponse(question);
    }

    public List<QuestionResponseDTO> findAll() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionResponseDTO> questionResponseDTOs = new ArrayList<QuestionResponseDTO>();
        for (Question question : questions) {
            questionResponseDTOs.add(questionMapper.toResponse(question));
        }
        return questionResponseDTOs;
    }
}
