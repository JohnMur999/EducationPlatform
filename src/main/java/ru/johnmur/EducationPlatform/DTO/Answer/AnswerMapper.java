package ru.johnmur.EducationPlatform.DTO.Answer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.johnmur.EducationPlatform.model.Answer;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rating", ignore = true)
    Answer toEntity(AnswerRequestDTO dto);

    AnswerResponseDTO toResponse(Answer answer);
}
