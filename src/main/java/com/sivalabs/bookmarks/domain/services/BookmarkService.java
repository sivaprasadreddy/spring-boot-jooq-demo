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
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Bookmark> searchBookmarks(String query) {
        return repository.searchBookmarksByTitle(query);
    }

    @Transactional(readOnly = true)
    public List<Bookmark> getBookmarksByTag(String tag) {
        return repository.fetchBookmarksByTag(tag);
    }

    @Transactional(readOnly = true)
    public Optional<Bookmark> getBookmarkById(Long id) {
        return repository.findById(id);
    }

    public Bookmark createBookmark(Bookmark bookmark) {
        return repository.save(bookmark);
    }

    @Transactional(readOnly = true)
    public List<Tag> findAllTags() {
        return repository.findAllTags();
    }
}