package ru.johnmur.EducationPlatform.DTO.User;

import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.UserRepository;

@Component
public class UserMapperHelper {

    @Named("mapAuthor")
    public User mapAuthor(Long authorId, @Context UserRepository userRepository) {
        return userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User with ID " + authorId + " not found"));
    }
}
