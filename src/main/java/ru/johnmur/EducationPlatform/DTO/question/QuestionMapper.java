package ru.johnmur.EducationPlatform.DTO.question;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.johnmur.EducationPlatform.DTO.user.UserMapperHelper;
import ru.johnmur.EducationPlatform.model.Question;

@Mapper(componentModel = "spring", uses = {UserMapperHelper.class})
public interface QuestionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    Question toEntity(QuestionRequestDTO dto);

    @Mapping(target = "authorId", source = "author.id")
    QuestionResponseDTO toResponse(Question question);
}




