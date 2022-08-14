/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables;


import com.sivalabs.bookmarks.jooq.DefaultSchema;
import com.sivalabs.bookmarks.jooq.Keys;
import com.sivalabs.bookmarks.jooq.tables.records.BookmarkTagRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookmarkTag extends TableImpl<BookmarkTagRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>BOOKMARK_TAG</code>
     */
    public static final BookmarkTag BOOKMARK_TAG = new BookmarkTag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookmarkTagRecord> getRecordType() {
        return BookmarkTagRecord.class;
    }

    /**
     * The column <code>BOOKMARK_TAG.BOOKMARK_ID</code>.
     */
    public final TableField<BookmarkTagRecord, Long> BOOKMARK_ID = createField(DSL.name("BOOKMARK_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>BOOKMARK_TAG.TAG_ID</code>.
     */
    public final TableField<BookmarkTagRecord, Long> TAG_ID = createField(DSL.name("TAG_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    private BookmarkTag(Name alias, Table<BookmarkTagRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookmarkTag(Name alias, Table<BookmarkTagRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>BOOKMARK_TAG</code> table reference
     */
    public BookmarkTag(String alias) {
        this(DSL.name(alias), BOOKMARK_TAG);
    }

    /**
     * Create an aliased <code>BOOKMARK_TAG</code> table reference
     */
    public BookmarkTag(Name alias) {
        this(alias, BOOKMARK_TAG);
    }

    /**
     * Create a <code>BOOKMARK_TAG</code> table reference
     */
    public BookmarkTag() {
        this(DSL.name("BOOKMARK_TAG"), null);
    }

    public <O extends Record> BookmarkTag(Table<O> child, ForeignKey<O, BookmarkTagRecord> key) {
        super(child, key, BOOKMARK_TAG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<ForeignKey<BookmarkTagRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_F, Keys.CONSTRAINT_FE);
    }

    private transient Bookmarks _bookmarks;
    private transient Tags _tags;

    /**
     * Get the implicit join path to the <code>PUBLIC.BOOKMARKS</code> table.
     */
    public Bookmarks bookmarks() {
        if (_bookmarks == null)
            _bookmarks = new Bookmarks(this, Keys.CONSTRAINT_F);

        return _bookmarks;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.TAGS</code> table.
     */
    public Tags tags() {
        if (_tags == null)
            _tags = new Tags(this, Keys.CONSTRAINT_FE);

        return _tags;
    }

    @Override
    public BookmarkTag as(String alias) {
        return new BookmarkTag(DSL.name(alias), this);
    }

    @Override
    public BookmarkTag as(Name alias) {
        return new BookmarkTag(alias, this);
    }

    @Override
    public BookmarkTag as(Table<?> alias) {
        return new BookmarkTag(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookmarkTag rename(String name) {
        return new BookmarkTag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookmarkTag rename(Name name) {
        return new BookmarkTag(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookmarkTag rename(Table<?> name) {
        return new BookmarkTag(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Long, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Long, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}