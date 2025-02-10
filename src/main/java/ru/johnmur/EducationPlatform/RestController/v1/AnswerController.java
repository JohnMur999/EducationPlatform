package ru.johnmur.EducationPlatform.RestController.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerRequestDTO;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerResponseDTO;
import ru.johnmur.EducationPlatform.service.AnswerService;

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
}
