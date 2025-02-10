package ru.johnmur.EducationPlatform.DTO.answer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Context;
import ru.johnmur.EducationPlatform.DTO.user.UserMapperHelper;
import ru.johnmur.EducationPlatform.model.Answer;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.UserRepository;

@Mapper(componentModel = "spring", uses = {UserMapperHelper.class})
public interface AnswerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "author", expression = "java(userRepository.findById(dto.getAuthorId()).orElseThrow(() -> new RuntimeException(\"User not found\")))")
    Answer toEntity(AnswerRequestDTO dto, Question question, @Context UserRepository userRepository);

    @Mapping(target = "authorId", source = "author.id")
    AnswerResponseDTO toResponse(Answer answer);
}
