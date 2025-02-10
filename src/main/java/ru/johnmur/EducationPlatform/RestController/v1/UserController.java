package ru.johnmur.EducationPlatform.RestController.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.johnmur.EducationPlatform.DTO.UserResponseDTO;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
