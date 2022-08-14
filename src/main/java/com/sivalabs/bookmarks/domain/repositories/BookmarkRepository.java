package com.sivalabs.bookmarks.domain.repositories;

import com.sivalabs.bookmarks.domain.models.Bookmark;
import com.sivalabs.bookmarks.domain.models.Tag;
import com.sivalabs.bookmarks.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.sivalabs.bookmarks.jooq.Tables.BOOKMARKS;
import static com.sivalabs.bookmarks.jooq.Tables.BOOKMARK_TAG;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.row;
import static org.jooq.impl.DSL.select;

@Repository
@RequiredArgsConstructor
public class BookmarkRepository {
    private final DSLContext dsl;

    public List<Bookmark> findAll() {
        return dsl.select(
                BOOKMARKS.ID, BOOKMARKS.TITLE, BOOKMARKS.URL,
                row(
                    BOOKMARKS.users().ID,
                    BOOKMARKS.users().NAME
                ).mapping(User::new),
                multiset(
                    select(BOOKMARK_TAG.tags().ID, BOOKMARK_TAG.tags().NAME)
                    .from(BOOKMARK_TAG)
                    .where(BOOKMARK_TAG.BOOKMARK_ID.eq(BOOKMARKS.ID))
                ).as("tags").convertFrom(r -> r.map(mapping(Tag::new)))
                )
                .from(BOOKMARKS)
                .orderBy(BOOKMARKS.TITLE)
                .fetch(mapping(Bookmark::new));
    }

    public List<Bookmark> searchBookmarksByTitle(String query) {
        return null;
    }

    public List<Bookmark> fetchBookmarksByCategory(String categoryName) {
        return null;
    }

    public Optional<Bookmark> findById(Long id) {
        return null;
    }

    public Bookmark save(Bookmark bookmark) {
        return null;
    }
}
