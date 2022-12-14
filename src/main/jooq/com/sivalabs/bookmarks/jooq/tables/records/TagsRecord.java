/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables.records;


import com.sivalabs.bookmarks.jooq.tables.Tags;
import com.sivalabs.bookmarks.jooq.tables.pojos.JooqTags;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagsRecord extends UpdatableRecordImpl<TagsRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tags.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tags.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.tags.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tags.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Tags.TAGS.ID;
    }

    @Override
    public Field<String> field2() {
        return Tags.TAGS.NAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public TagsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TagsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TagsRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagsRecord
     */
    public TagsRecord() {
        super(Tags.TAGS);
    }

    /**
     * Create a detached, initialised TagsRecord
     */
    public TagsRecord(Long id, String name) {
        super(Tags.TAGS);

        setId(id);
        setName(name);
    }

    /**
     * Create a detached, initialised TagsRecord
     */
    public TagsRecord(JooqTags value) {
        super(Tags.TAGS);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
        }
    }
}
