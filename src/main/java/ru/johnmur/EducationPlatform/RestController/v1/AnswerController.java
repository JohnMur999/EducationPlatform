package ru.johnmur.EducationPlatform.RestController.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.johnmur.EducationPlatform.repository.AnswerRepository;
import ru.johnmur.EducationPlatform.service.AnswerService;

@RestController
@RequestMapping("api/v1/answers")
public class AnswerController {
    private static AnswerService answerService;

    AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/{id}")
    public ResponseEntity createAnswer(@RequestBody Long id, String content) {
        return ResponseEntity.status(HttpStatus.CREATED).body(AnswerService.createAnswer());
    }
}
