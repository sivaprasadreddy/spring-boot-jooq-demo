package com.sivalabs.bookmarks.domain.repositories;

import com.sivalabs.bookmarks.common.PostgresDatabaseContainerInitializer;
import com.sivalabs.bookmarks.domain.models.Bookmark;
import com.sivalabs.bookmarks.domain.models.Tag;
import com.sivalabs.bookmarks.domain.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JooqTest
@Import(BookmarkRepository.class)
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
public class BookmarkRepositoryTest {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Test
    void shouldGetAllBookmarks() {
        List<Bookmark> allBookmarks = bookmarkRepository.findAll();
        assertThat(allBookmarks).isNotEmpty();
    }

    @Test
    void shouldSearchBookmarks() {
        List<Bookmark> bookmarks = bookmarkRepository.searchBookmarksByTitle("va");
        assertThat(bookmarks).isNotEmpty();
    }

    @Test
    void shouldGetBookmarksByTag() {
        List<Bookmark> bookmarks = bookmarkRepository.fetchBookmarksByTag("java");
        assertThat(bookmarks).isNotEmpty();
    }

    @Test
    void shouldGetBookmarkById() {
        Bookmark bookmark = bookmarkRepository.findById(1L).orElse(null);
        System.out.println(bookmark);
        assertThat(bookmark).isNotNull();
    }

    @Test
    void shouldGetAllTags() {
        List<Tag> tags = bookmarkRepository.findAllTags();
        assertThat(tags).isNotEmpty();
    }

    @Test
    void shouldCreateBookmark() {
        User user = new User(1L,"siva");
        Tag tag1 = new Tag(1L,"java");
        Tag tag2 = new Tag(1L,"spring-cloud");
        Bookmark bookmark = new Bookmark(null, "ss", "https://ss.com", user, List.of(tag1, tag2));

        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        assertThat(savedBookmark).isNotNull();
        assertThat(savedBookmark.id()).isNotNull();
    }
}