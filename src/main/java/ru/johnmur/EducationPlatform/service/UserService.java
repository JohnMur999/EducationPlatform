package ru.johnmur.EducationPlatform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.DTO.user.UserMapper;
import ru.johnmur.EducationPlatform.DTO.user.UserRequestDTO;
import ru.johnmur.EducationPlatform.DTO.user.UserResponseDTO;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO getUserById(long id) {
        logger.info("[SERVICE METHOD] Get user by id: " + id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        return userMapper.toResponse(user);
    }

    public UserResponseDTO getUserByUsername(String username) {
        logger.info("[SERVICE METHOD] Get user by username: " + username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with username " + username + " not found"));

        return userMapper.toResponse(user);
    }

    public void deleteUserById(Long id) {
        logger.info("[SERVICE METHOD] Delete user by id: " + id);
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        logger.info("[SERVICE METHOD] Create user");

        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        logger.info("[SERVICE METHOD] Get all users");

        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }
}
