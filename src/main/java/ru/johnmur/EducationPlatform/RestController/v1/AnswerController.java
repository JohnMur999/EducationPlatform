package ru.johnmur.EducationPlatform.RestController.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.johnmur.EducationPlatform.DTO.answer.AnswerRequestDTO;
import ru.johnmur.EducationPlatform.DTO.answer.AnswerResponseDTO;
import ru.johnmur.EducationPlatform.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<AnswerResponseDTO> createAnswer(@RequestBody AnswerRequestDTO dto) {
        AnswerResponseDTO savedAnswer = answerService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnswer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> getAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> getAnswersByQuestion(@RequestParam Long questionId) {
        List<AnswerResponseDTO> answers = answerService.findByQuestionId(questionId);
        return ResponseEntity.ok(answers);
    }
}
