package ru.johnmur.EducationPlatform.DTO.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.johnmur.EducationPlatform.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponse(User user);
}
