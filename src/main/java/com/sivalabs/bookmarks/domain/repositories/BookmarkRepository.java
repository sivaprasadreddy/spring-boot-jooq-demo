package com.sivalabs.bookmarks.domain.repositories;

import com.sivalabs.bookmarks.domain.models.Bookmark;
import com.sivalabs.bookmarks.domain.models.Tag;
import com.sivalabs.bookmarks.domain.models.User;
import com.sivalabs.bookmarks.jooq.tables.records.BookmarksRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record5;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sivalabs.bookmarks.jooq.Tables.BOOKMARKS;
import static com.sivalabs.bookmarks.jooq.Tables.BOOKMARK_TAG;
import static com.sivalabs.bookmarks.jooq.Tables.TAGS;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.row;
import static org.jooq.impl.DSL.select;

@Repository
@RequiredArgsConstructor
public class BookmarkRepository {
    private final DSLContext dsl;

    public List<Bookmark> findAll() {
        return getCommonRootSpec()
                .orderBy(BOOKMARKS.TITLE)
                .fetch(mapping(Bookmark::new));
    }

    public Optional<Bookmark> findById(Long id) {
        Bookmark bookmark = getCommonRootSpec()
                .where(BOOKMARKS.ID.eq(id))
                .fetchOne(mapping(Bookmark::new));
        return Optional.ofNullable(bookmark);
    }

    public List<Bookmark> searchBookmarksByTitle(String query) {
        return getCommonRootSpec()
                .where(BOOKMARKS.TITLE.likeRegex(query))
                .orderBy(BOOKMARKS.TITLE)
                .fetch(mapping(Bookmark::new));
    }

    public List<Bookmark> fetchBookmarksByTag(String tagName) {
        return getCommonRootSpec()
                .join(BOOKMARK_TAG).on(BOOKMARK_TAG.BOOKMARK_ID.eq(BOOKMARKS.ID))
                .join(TAGS).on(BOOKMARK_TAG.TAG_ID.eq(TAGS.ID))
                .where(TAGS.NAME.eq(tagName))
                .fetch(mapping(Bookmark::new));
    }

    public Bookmark save(Bookmark bookmark) {
        BookmarksRecord bookmarksRecord = dsl.insertInto(BOOKMARKS)
                .set(BOOKMARKS.TITLE, bookmark.title())
                .set(BOOKMARKS.URL, bookmark.url())
                .set(BOOKMARKS.CREATED_BY, bookmark.createdBy().id())
                .set(BOOKMARKS.CREATED_AT, LocalDateTime.now())
                .returning(BOOKMARKS.ID)
                .fetchSingle();
        this.saveTags(bookmark.tags());
        for (Tag tag : bookmark.tags()) {
            dsl.insertInto(BOOKMARK_TAG)
                    .set(BOOKMARK_TAG.BOOKMARK_ID, bookmarksRecord.getId())
                    .set(BOOKMARK_TAG.TAG_ID, tag.id())
                    .execute();
        }
        return findById(bookmarksRecord.getId()).orElseThrow();
    }

    public List<Tag> findAllTags() {
        return dsl.selectFrom(TAGS).fetch(mapping(Tag::new));
    }

    public List<Tag> saveTags(List<Tag> tags) {
        List<Tag> tagsResult = new ArrayList<>();
        for (Tag tag : tags) {
            /*
            dsl.mergeInto(TAGS)
                    .using(selectOne())
                    .on(TAGS.NAME.eq(tag.name()))
                    .whenNotMatchedThenInsert(TAGS.NAME)
                    .values(tag.name())
                    .execute();
            */
            Optional<Tag> tagByName = getTagByName(tag.name());
            if(tagByName.isPresent()) {
                tagsResult.add(tagByName.get());
            } else {
                tagsResult.add(this.createTag(tag));
            }
        }
        return tagsResult;
    }

    public Tag createTag(Tag tag) {
        return dsl.insertInto(TAGS)
                .set(TAGS.NAME, tag.name())
                .returning(TAGS.ID)
                .fetchSingle(mapping(Tag::new));
    }

    public Optional<Tag> getTagByName(String tagName) {
        var tag = dsl.selectFrom(TAGS)
                .where(TAGS.NAME.equalIgnoreCase(tagName))
                .fetchOne(mapping(Tag::new));
        return Optional.ofNullable(tag);
    }

    private SelectJoinStep<Record5<Long, String, String, User, List<Tag>>> getCommonRootSpec() {
        return dsl.select(
                BOOKMARKS.ID, BOOKMARKS.URL, BOOKMARKS.TITLE,
                row(
                    BOOKMARKS.users().ID,
                    BOOKMARKS.users().NAME,
                    BOOKMARKS.users().EMAIL,
                    DSL.inline(null, SQLDataType.VARCHAR).as("password")
                ).mapping(User::new).as("user"),
                multiset(
                    select(BOOKMARK_TAG.tags().ID, BOOKMARK_TAG.tags().NAME)
                    .from(BOOKMARK_TAG)
                    .where(BOOKMARK_TAG.BOOKMARK_ID.eq(BOOKMARKS.ID))
                ).as("tags").convertFrom(r -> r.map(mapping(Tag::new)))
            )
            .from(BOOKMARKS);
    }
}
