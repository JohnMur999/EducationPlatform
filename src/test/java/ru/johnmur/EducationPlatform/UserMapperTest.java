package ru.johnmur.EducationPlatform;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.johnmur.EducationPlatform.DTO.UserMapper;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testMapperBeanExists() {
        assertThat(userMapper).isNotNull();
    }
}
