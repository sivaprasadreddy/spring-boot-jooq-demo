package com.sivalabs.bookmarks.repositories;

import com.sivalabs.bookmarks.models.User;
import com.sivalabs.bookmarks.models.UserWithBookmarks;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@JooqTest
@Import({UserRepository.class})
@Testcontainers
@Sql("classpath:/test-data.sql")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16-alpine");

    @Test
    void findAllUsers() {
        List<User> users = userRepository.findAllUsers();
        assertThat(users).hasSize(2);
        //more assertions
    }

    @Test
    void findUserById() {
        Optional<User> userOptional = userRepository.findUserById(1L);
        assertThat(userOptional).isPresent();
        User user = userOptional.get();
        assertThat(user.id()).isEqualTo(1L);
        assertThat(user.name()).isEqualTo("Admin");
        assertThat(user.email()).isEqualTo("admin@gmail.com");
        assertThat(user.password()).isEqualTo("admin");
        assertThat(user.password()).isEqualTo("admin");
        assertThat(user.preferences().id()).isEqualTo(2L);
        assertThat(user.preferences().theme()).isEqualTo("Dark");
        assertThat(user.preferences().language()).isEqualTo("EN");
    }

    @Test
    void createUser() {
        User user = new User(null, "SivaLabs", "sivalabs@gmail.com", "siva1234");

        User savedUser = userRepository.createUser(user);
        assertThat(savedUser.id()).isNotNull();
        assertThat(savedUser.name()).isEqualTo("SivaLabs");
        assertThat(savedUser.email()).isEqualTo("sivalabs@gmail.com");
        assertThat(savedUser.password()).isEqualTo("siva1234");
    }

    @Test
    void updateUser() {
        User user = createTestUser();
        User updateUser = new User(user.id(), "TestName1", user.email(), user.password());
        userRepository.updateUser(updateUser);

        User updatedUser = userRepository.findUserById(updateUser.id()).orElseThrow();

        assertThat(updatedUser.id()).isEqualTo(updateUser.id());
        assertThat(updatedUser.name()).isEqualTo("TestName1");
        assertThat(updatedUser.email()).isEqualTo(user.email());
        assertThat(updatedUser.password()).isEqualTo(user.password());
    }

    @Test
    void deleteUser() {
        User user = createTestUser();
        userRepository.deleteUser(user.id());

        Optional<User> optionalUser = userRepository.findUserById(user.id());
        assertThat(optionalUser).isEmpty();
    }

    @Test
    void getUserWithBookmarks() {
        Optional<UserWithBookmarks> userOptional = userRepository.getUserWithBookmarksById(2L);
        assertThat(userOptional).isPresent();
        UserWithBookmarks user = userOptional.get();
        assertThat(user.id()).isEqualTo(2L);
        assertThat(user.name()).isEqualTo("Siva");
        assertThat(user.email()).isEqualTo("siva@gmail.com");

        assertThat(user.bookmarks()).hasSize(2);

        var bookmark1 = new UserWithBookmarks.BookmarkInfo(2L, "Spring Initializr", "https://start.spring.io");
        var bookmark2 = new UserWithBookmarks.BookmarkInfo(3L, "Spring Blog", "https://spring.io/blog");

        assertThat(user.bookmarks()).contains(bookmark1, bookmark2);
    }

    private User createTestUser() {
        String uuid = UUID.randomUUID().toString();
        User user = new User(null, uuid, uuid+"@gmail.com", "Secret");
        return userRepository.createUser(user);
    }
}