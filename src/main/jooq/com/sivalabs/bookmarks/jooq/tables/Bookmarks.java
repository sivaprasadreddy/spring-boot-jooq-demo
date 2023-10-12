/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables;


import com.sivalabs.bookmarks.jooq.Keys;
import com.sivalabs.bookmarks.jooq.Public;
import com.sivalabs.bookmarks.jooq.tables.records.BookmarksRecord;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bookmarks extends TableImpl<BookmarksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.bookmarks</code>
     */
    public static final Bookmarks BOOKMARKS = new Bookmarks();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookmarksRecord> getRecordType() {
        return BookmarksRecord.class;
    }

    /**
     * The column <code>public.bookmarks.id</code>.
     */
    public final TableField<BookmarksRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.bookmarks.url</code>.
     */
    public final TableField<BookmarksRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>public.bookmarks.title</code>.
     */
    public final TableField<BookmarksRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>public.bookmarks.created_by</code>.
     */
    public final TableField<BookmarksRecord, Long> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.bookmarks.created_at</code>.
     */
    public final TableField<BookmarksRecord, OffsetDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.bookmarks.updated_at</code>.
     */
    public final TableField<BookmarksRecord, OffsetDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "");

    private Bookmarks(Name alias, Table<BookmarksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bookmarks(Name alias, Table<BookmarksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.bookmarks</code> table reference
     */
    public Bookmarks(String alias) {
        this(DSL.name(alias), BOOKMARKS);
    }

    /**
     * Create an aliased <code>public.bookmarks</code> table reference
     */
    public Bookmarks(Name alias) {
        this(alias, BOOKMARKS);
    }

    /**
     * Create a <code>public.bookmarks</code> table reference
     */
    public Bookmarks() {
        this(DSL.name("bookmarks"), null);
    }

    public <O extends Record> Bookmarks(Table<O> child, ForeignKey<O, BookmarksRecord> key) {
        super(child, key, BOOKMARKS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<BookmarksRecord, Long> getIdentity() {
        return (Identity<BookmarksRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<BookmarksRecord> getPrimaryKey() {
        return Keys.BOOKMARKS_PKEY;
    }

    @Override
    public List<ForeignKey<BookmarksRecord, ?>> getReferences() {
        return Arrays.asList(Keys.BOOKMARKS__BOOKMARKS_CREATED_BY_FKEY);
    }

    private transient Users _users;

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.BOOKMARKS__BOOKMARKS_CREATED_BY_FKEY);

        return _users;
    }

    @Override
    public Bookmarks as(String alias) {
        return new Bookmarks(DSL.name(alias), this);
    }

    @Override
    public Bookmarks as(Name alias) {
        return new Bookmarks(alias, this);
    }

    @Override
    public Bookmarks as(Table<?> alias) {
        return new Bookmarks(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bookmarks rename(String name) {
        return new Bookmarks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bookmarks rename(Name name) {
        return new Bookmarks(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bookmarks rename(Table<?> name) {
        return new Bookmarks(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, Long, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super String, ? super String, ? super Long, ? super OffsetDateTime, ? super OffsetDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super String, ? super String, ? super Long, ? super OffsetDateTime, ? super OffsetDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
