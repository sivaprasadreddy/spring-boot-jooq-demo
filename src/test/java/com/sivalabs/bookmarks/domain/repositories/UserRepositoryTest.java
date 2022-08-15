package com.sivalabs.bookmarks.domain.repositories;

import com.sivalabs.bookmarks.common.PostgresDatabaseContainerInitializer;
import com.sivalabs.bookmarks.domain.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@JooqTest
@Import(UserRepository.class)
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findUserByEmail() {
        Optional<User> optionalUser = userRepository.findByEmail("siva@gmail.com");
        assertThat(optionalUser).isPresent();
    }

    @Test
    void userExistsByEmail() {
        assertThat(userRepository.existsByEmail("admin@gmail.com")).isTrue();
    }

    @Test
    void getUserById() {
        Optional<User> optionalUser = userRepository.getById(1L);
        assertThat(optionalUser).isPresent();
    }
}