package ru.johnmur.EducationPlatform.DTO.Question;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.johnmur.EducationPlatform.model.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rating", ignore = true)
    Question toEntity(QuestionRequestDTO dto);

    QuestionResponseDTO toResponse(Question question);
}

