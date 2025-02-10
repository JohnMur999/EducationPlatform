package ru.johnmur.EducationPlatform.DTO.Question;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerMapper;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {AnswerMapper.class})
public abstract class QuestionMapper {

    @Autowired
    private UserRepository userRepository; // Теперь получаем `User` из БД

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    public abstract Question toEntity(QuestionRequestDTO dto);

    @Mapping(target = "authorId", source = "author.id") // Конвертируем `User` → `Long`
    public abstract QuestionResponseDTO toResponse(Question question);

    @Named("mapAuthor")
    public User mapAuthor(Long authorId) {
        return userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User with ID " + authorId + " not found"));
    }
}
