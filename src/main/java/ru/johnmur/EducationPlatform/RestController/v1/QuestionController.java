package ru.johnmur.EducationPlatform.RestController.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionRequestDTO;
import ru.johnmur.EducationPlatform.DTO.Question.QuestionResponseDTO;
import ru.johnmur.EducationPlatform.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        return ResponseEntity.ok(questionService.findAll());
    }
}
