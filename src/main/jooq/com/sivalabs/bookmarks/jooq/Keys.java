/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq;


import com.sivalabs.bookmarks.jooq.tables.BookmarkTag;
import com.sivalabs.bookmarks.jooq.tables.Bookmarks;
import com.sivalabs.bookmarks.jooq.tables.Tags;
import com.sivalabs.bookmarks.jooq.tables.UserPreferences;
import com.sivalabs.bookmarks.jooq.tables.Users;
import com.sivalabs.bookmarks.jooq.tables.records.BookmarkTagRecord;
import com.sivalabs.bookmarks.jooq.tables.records.BookmarksRecord;
import com.sivalabs.bookmarks.jooq.tables.records.TagsRecord;
import com.sivalabs.bookmarks.jooq.tables.records.UserPreferencesRecord;
import com.sivalabs.bookmarks.jooq.tables.records.UsersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BookmarksRecord> BOOKMARKS_PKEY = Internal.createUniqueKey(Bookmarks.BOOKMARKS, DSL.name("bookmarks_pkey"), new TableField[] { Bookmarks.BOOKMARKS.ID }, true);
    public static final UniqueKey<TagsRecord> TAG_NAME_UNIQUE = Internal.createUniqueKey(Tags.TAGS, DSL.name("tag_name_unique"), new TableField[] { Tags.TAGS.NAME }, true);
    public static final UniqueKey<TagsRecord> TAGS_PKEY = Internal.createUniqueKey(Tags.TAGS, DSL.name("tags_pkey"), new TableField[] { Tags.TAGS.ID }, true);
    public static final UniqueKey<UserPreferencesRecord> USER_PREFERENCES_PKEY = Internal.createUniqueKey(UserPreferences.USER_PREFERENCES, DSL.name("user_preferences_pkey"), new TableField[] { UserPreferences.USER_PREFERENCES.ID }, true);
    public static final UniqueKey<UsersRecord> USER_EMAIL_UNIQUE = Internal.createUniqueKey(Users.USERS, DSL.name("user_email_unique"), new TableField[] { Users.USERS.EMAIL }, true);
    public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_pkey"), new TableField[] { Users.USERS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BookmarkTagRecord, BookmarksRecord> BOOKMARK_TAG__BOOKMARK_TAG_BOOKMARK_ID_FKEY = Internal.createForeignKey(BookmarkTag.BOOKMARK_TAG, DSL.name("bookmark_tag_bookmark_id_fkey"), new TableField[] { BookmarkTag.BOOKMARK_TAG.BOOKMARK_ID }, Keys.BOOKMARKS_PKEY, new TableField[] { Bookmarks.BOOKMARKS.ID }, true);
    public static final ForeignKey<BookmarkTagRecord, TagsRecord> BOOKMARK_TAG__BOOKMARK_TAG_TAG_ID_FKEY = Internal.createForeignKey(BookmarkTag.BOOKMARK_TAG, DSL.name("bookmark_tag_tag_id_fkey"), new TableField[] { BookmarkTag.BOOKMARK_TAG.TAG_ID }, Keys.TAGS_PKEY, new TableField[] { Tags.TAGS.ID }, true);
    public static final ForeignKey<BookmarksRecord, UsersRecord> BOOKMARKS__BOOKMARKS_CREATED_BY_FKEY = Internal.createForeignKey(Bookmarks.BOOKMARKS, DSL.name("bookmarks_created_by_fkey"), new TableField[] { Bookmarks.BOOKMARKS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<UsersRecord, UserPreferencesRecord> USERS__USERS_PREFERENCES_ID_FKEY = Internal.createForeignKey(Users.USERS, DSL.name("users_preferences_id_fkey"), new TableField[] { Users.USERS.PREFERENCES_ID }, Keys.USER_PREFERENCES_PKEY, new TableField[] { UserPreferences.USER_PREFERENCES.ID }, true);
}
