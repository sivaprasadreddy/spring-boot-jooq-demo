package com.sivalabs.bookmarks.repositories;

import com.sivalabs.bookmarks.models.BookmarkWithTags;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.sivalabs.bookmarks.jooq.Tables.BOOKMARK_TAG;
import static com.sivalabs.bookmarks.jooq.tables.Bookmarks.BOOKMARKS;
import static com.sivalabs.bookmarks.jooq.tables.Tags.TAGS;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

@Repository
public class BookmarkRepository {
    private final DSLContext dsl;

    public BookmarkRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<BookmarkWithTags> getBookmarksWithTags() {
        return dsl
                .select(
                    BOOKMARKS.ID, BOOKMARKS.TITLE, BOOKMARKS.URL,
                    multiset(
                        select(TAGS.ID, TAGS.NAME)
                        .from(TAGS)
                        .join(BOOKMARK_TAG)
                        .on(BOOKMARK_TAG.TAG_ID.eq(TAGS.ID))
                        .where(BOOKMARK_TAG.BOOKMARK_ID.eq(BOOKMARKS.ID))
                    ).as("tags").convertFrom(r -> r.map(mapping(BookmarkWithTags.TagInfo::new)))
                )
                .from(BOOKMARKS)
                .fetch(mapping(BookmarkWithTags::new));
    }
}
