package com.sivalabs.bookmarks.repositories;

import com.sivalabs.bookmarks.models.BookmarkWithTags;
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

import static org.assertj.core.api.Assertions.assertThat;

@JooqTest
@Import({BookmarkRepository.class})
@Testcontainers
@Sql("classpath:/test-data.sql")
class BookmarkRepositoryTest {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16-alpine");

    @Test
    void getBookmarksWithTags() {
        var bookmarksWithTags = bookmarkRepository.getBookmarksWithTags();
        assertThat(bookmarksWithTags).hasSize(3);

        var javaTag = new BookmarkWithTags.TagInfo(1L, "java");
        var springBootTag = new BookmarkWithTags.TagInfo(2L, "spring-boot");
        var springCloudTag = new BookmarkWithTags.TagInfo(3L, "spring-cloud");
        var devopsTag = new BookmarkWithTags.TagInfo(4L, "devops");

        var bookmark1 = new BookmarkWithTags(1L, "SivaLabs", "https://sivalabs.in",
                List.of(javaTag, springBootTag, springCloudTag));
        var bookmark2 = new BookmarkWithTags(2L, "Spring Initializr", "https://start.spring.io",
                List.of(springBootTag));
        var bookmark3 = new BookmarkWithTags(3L, "Spring Blog", "https://spring.io/blog",
                List.of(springBootTag, springCloudTag, devopsTag));

        assertThat(bookmarksWithTags).contains(bookmark1, bookmark2, bookmark3);
    }
}