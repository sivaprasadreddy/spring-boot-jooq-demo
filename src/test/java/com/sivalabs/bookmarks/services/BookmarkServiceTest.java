package com.sivalabs.bookmarks.services;

import com.sivalabs.bookmarks.domain.models.Bookmark;
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
}