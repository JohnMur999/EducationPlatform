package ru.johnmur.EducationPlatform.DTO.answer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.johnmur.EducationPlatform.DTO.user.UserMapperHelper;
import ru.johnmur.EducationPlatform.model.Answer;

@Mapper(componentModel = "spring", uses = {UserMapperHelper.class})
public interface AnswerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    @Mapping(target = "question", source = "questionId", qualifiedByName = "mapQuestion")
    Answer toEntity(AnswerRequestDTO dto);

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "questionId", source = "question.id")
    AnswerResponseDTO toResponse(Answer answer);
}



