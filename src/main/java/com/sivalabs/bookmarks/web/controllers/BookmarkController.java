package com.sivalabs.bookmarks.web.controllers;

import javax.validation.Valid;

import com.sivalabs.bookmarks.domain.models.Bookmark;
import com.sivalabs.bookmarks.domain.models.Tag;
import com.sivalabs.bookmarks.domain.services.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping("/bookmarks")
    public List<Bookmark> getBookmarks() {
        return bookmarkService.getAllBookmarks();
    }

    @GetMapping("/bookmarks/search")
    public List<Bookmark> search(@RequestParam(name = "query") String query) {
        log.info("Searching bookmarks for {}", query);
        return bookmarkService.searchBookmarks(query);
    }

    @GetMapping("/bookmarks/{id}")
    public Bookmark getBookmark(@PathVariable Long id) {
        return bookmarkService.getBookmarkById(id).orElse(null);
    }

    @PostMapping("/bookmarks")
    @ResponseStatus(HttpStatus.CREATED)
    public Bookmark createBookmark(@Valid @RequestBody Bookmark bookmark) {
        return bookmarkService.createBookmark(bookmark);
    }

    @GetMapping("/tags")
    public List<Tag> allTags() {
        return bookmarkService.findAllTags();
    }

    @GetMapping("/tags/{tag}")
    public List<Bookmark> bookmarksByCategory(@PathVariable(name = "tag") String tag) {
        log.info("Fetching bookmarks for tag {} ", tag);
        return bookmarkService.getBookmarksByTag(tag);
    }
}
