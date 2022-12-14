/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables.daos;


import com.sivalabs.bookmarks.jooq.tables.Tags;
import com.sivalabs.bookmarks.jooq.tables.pojos.JooqTags;
import com.sivalabs.bookmarks.jooq.tables.records.TagsRecord;

import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class TagsRepository extends DAOImpl<TagsRecord, JooqTags, Long> {

    /**
     * Create a new TagsRepository without any configuration
     */
    public TagsRepository() {
        super(Tags.TAGS, JooqTags.class);
    }

    /**
     * Create a new TagsRepository with an attached configuration
     */
    @Autowired
    public TagsRepository(Configuration configuration) {
        super(Tags.TAGS, JooqTags.class, configuration);
    }

    @Override
    public Long getId(JooqTags object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqTags> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Tags.TAGS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<JooqTags> fetchById(Long... values) {
        return fetch(Tags.TAGS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public JooqTags fetchOneById(Long value) {
        return fetchOne(Tags.TAGS.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<JooqTags> fetchOptionalById(Long value) {
        return fetchOptional(Tags.TAGS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqTags> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Tags.TAGS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<JooqTags> fetchByName(String... values) {
        return fetch(Tags.TAGS.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public JooqTags fetchOneByName(String value) {
        return fetchOne(Tags.TAGS.NAME, value);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public Optional<JooqTags> fetchOptionalByName(String value) {
        return fetchOptional(Tags.TAGS.NAME, value);
    }
}
