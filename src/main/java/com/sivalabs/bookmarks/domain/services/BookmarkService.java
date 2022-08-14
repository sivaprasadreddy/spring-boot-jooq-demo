package com.sivalabs.bookmarks.domain.services;

import com.sivalabs.bookmarks.domain.models.Bookmark;
import com.sivalabs.bookmarks.domain.models.Tag;
import com.sivalabs.bookmarks.domain.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BookmarkService {
    private final BookmarkRepository repository;

    @Transactional(readOnly = true)
    public List<Bookmark> getAllBookmarks() {
        var bookmarks = repository.findAll();
        return bookmarks;
    }
    @Transactional(readOnly = true)
    public Optional<Bookmark> getBookmarkById(Long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Bookmark> searchBookmarks(String query) {
        return List.of();
    }

    @Transactional(readOnly = true)
    public List<Bookmark> getBookmarksByTag(String tag) {
        return List.of();
    }

    public Bookmark createBookmark(Bookmark bookmark) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<Tag> findAllTags() {
        return List.of();
    }
}