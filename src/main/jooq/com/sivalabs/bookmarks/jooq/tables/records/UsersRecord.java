/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables.records;


import com.sivalabs.bookmarks.jooq.tables.Users;
import com.sivalabs.bookmarks.jooq.tables.pojos.JooqUsers;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record7<Long, String, String, String, Long, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.users.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.users.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.users.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.users.password</code>.
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.users.password</code>.
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.users.addr_id</code>.
     */
    public void setAddrId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.users.addr_id</code>.
     */
    public Long getAddrId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.users.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.users.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.users.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.users.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, String, String, String, Long, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, String, String, String, Long, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.PASSWORD;
    }

    @Override
    public Field<Long> field5() {
        return Users.USERS.ADDR_ID;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Users.USERS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Users.USERS.UPDATED_AT;
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
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getPassword();
    }

    @Override
    public Long component5() {
        return getAddrId();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component7() {
        return getUpdatedAt();
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
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getPassword();
    }

    @Override
    public Long value5() {
        return getAddrId();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value7() {
        return getUpdatedAt();
    }

    @Override
    public UsersRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UsersRecord value5(Long value) {
        setAddrId(value);
        return this;
    }

    @Override
    public UsersRecord value6(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UsersRecord value7(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public UsersRecord values(Long value1, String value2, String value3, String value4, Long value5, LocalDateTime value6, LocalDateTime value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Long id, String name, String email, String password, Long addrId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Users.USERS);

        setId(id);
        setName(name);
        setEmail(email);
        setPassword(password);
        setAddrId(addrId);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(JooqUsers value) {
        super(Users.USERS);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setEmail(value.getEmail());
            setPassword(value.getPassword());
            setAddrId(value.getAddrId());
            setCreatedAt(value.getCreatedAt());
            setUpdatedAt(value.getUpdatedAt());
            resetChangedOnNotNull();
        }
    }
}
