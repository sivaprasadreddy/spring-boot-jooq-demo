package com.sivalabs.bookmarks.services;

import com.sivalabs.bookmarks.domain.models.Bookmark;
import com.sivalabs.bookmarks.domain.models.Tag;
import com.sivalabs.bookmarks.domain.models.User;
import com.sivalabs.bookmarks.domain.services.BookmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookmarkServiceTest {

    @Autowired
    BookmarkService bookmarkService;

    @Test
    void shouldGetAllBookmarks() {
        List<Bookmark> allBookmarks = bookmarkService.getAllBookmarks();
        assertThat(allBookmarks).isNotEmpty();
    }

    @Test
    void shouldSearchBookmarks() {
        List<Bookmark> bookmarks = bookmarkService.searchBookmarks("va");
        assertThat(bookmarks).isNotEmpty();
    }

    @Test
    void shouldGetBookmarksByTag() {
        List<Bookmark> bookmarks = bookmarkService.getBookmarksByTag("java");
        assertThat(bookmarks).isNotEmpty();
    }

    @Test
    void shouldGetBookmarkById() {
        Bookmark bookmark = bookmarkService.getBookmarkById(1L).orElse(null);
        System.out.println(bookmark);
        assertThat(bookmark).isNotNull();
    }

    @Test
    void shouldGetAllTags() {
        List<Tag> tags = bookmarkService.findAllTags();
        assertThat(tags).isNotEmpty();
    }

    @Test
    void shouldCreateBookmark() {
        User user = new User(1L,"siva");
        Tag tag1 = new Tag(1L,"java");
        Tag tag2 = new Tag(1L,"spring-cloud");
        Bookmark bookmark = new Bookmark(null, "ss", "https://ss.com", user, List.of(tag1, tag2));

        Bookmark savedBookmark = bookmarkService.createBookmark(bookmark);
        assertThat(savedBookmark).isNotNull();
        assertThat(savedBookmark.id()).isNotNull();
    }
}