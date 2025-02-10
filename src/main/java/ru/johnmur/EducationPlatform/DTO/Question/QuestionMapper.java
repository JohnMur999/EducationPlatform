package ru.johnmur.EducationPlatform.DTO.Question;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Context;
import ru.johnmur.EducationPlatform.DTO.Answer.AnswerMapper;
import ru.johnmur.EducationPlatform.DTO.User.UserMapperHelper;
import ru.johnmur.EducationPlatform.model.Question;
import ru.johnmur.EducationPlatform.repository.UserRepository;

@Mapper(componentModel = "spring", uses = {AnswerMapper.class, UserMapperHelper.class})
public interface QuestionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    Question toEntity(QuestionRequestDTO dto, @Context UserRepository userRepository);

    @Mapping(target = "authorId", source = "author.id")
    QuestionResponseDTO toResponse(Question question);
}
