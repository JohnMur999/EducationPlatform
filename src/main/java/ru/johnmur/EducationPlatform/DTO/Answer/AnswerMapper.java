package ru.johnmur.EducationPlatform.DTO.Answer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.johnmur.EducationPlatform.model.Answer;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AnswerMapper {

    @Autowired
    private UserRepository userRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    public abstract Answer toEntity(AnswerRequestDTO dto, Question question);

    @Mapping(target = "authorId", source = "author.id") // Преобразуем User → authorId
    public abstract AnswerResponseDTO toResponse(Answer answer);

    @Named("mapAuthor")
    public User mapAuthor(Long authorId) {
        return userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User with ID " + authorId + " not found"));
    }
}
