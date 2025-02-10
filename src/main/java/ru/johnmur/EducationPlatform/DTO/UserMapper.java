package ru.johnmur.EducationPlatform.DTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;
import ru.johnmur.EducationPlatform.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponse(User user);
}
