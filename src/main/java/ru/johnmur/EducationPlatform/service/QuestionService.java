package ru.johnmur.EducationPlatform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionMapper;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionRequestDTO;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionResponseDTO;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.QuestionRepository;
import ru.johnmur.EducationPlatform.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, UserRepository userRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.questionMapper = questionMapper;
    }

    /**
     * Создание нового вопроса с привязкой к существующему пользователю
     */
    public QuestionResponseDTO save(QuestionRequestDTO dto) {
        logger.info("[SERVICE] Creating new question: {}", dto.getTitle());

        // Проверяем, существует ли автор вопроса
        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User with ID " + dto.getAuthorId() + " not found"));

        // Создаём вопрос, заполняем поля
        Question question = questionMapper.toEntity(dto);
        question.setAuthor(author); // Привязываем пользователя как автора

        // Сохраняем в БД
        Question savedQuestion = questionRepository.save(question);

        // Возвращаем DTO ответа
        return questionMapper.toResponse(savedQuestion);
    }

    /**
     * Получение вопроса по ID
     */
    public QuestionResponseDTO findById(Long id) {
        logger.info("[SERVICE] Finding question by ID: {}", id);
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question with ID " + id + " not found"));
        return questionMapper.toResponse(question);
    }

    /**
     * Получение всех вопросов
     */
    public List<QuestionResponseDTO> findAll() {
        logger.info("[SERVICE] Retrieving all questions");
        return questionRepository.findAll()
                .stream()
                .map(questionMapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Поиск вопроса по названию
     */
    public QuestionResponseDTO findByTitle(String title) {
        logger.info("[SERVICE] Finding question by title: {}", title);
        Question question = questionRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Question with title '" + title + "' not found"));
        return questionMapper.toResponse(question);
    }
}
