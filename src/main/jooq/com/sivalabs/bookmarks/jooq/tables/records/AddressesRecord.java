/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables.records;


import com.sivalabs.bookmarks.jooq.tables.Addresses;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressesRecord extends UpdatableRecordImpl<AddressesRecord> implements Record6<Long, String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.addresses.id</code>.
     */
    public AddressesRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.addresses.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.addresses.street</code>.
     */
    public AddressesRecord setStreet(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.addresses.street</code>.
     */
    public String getStreet() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.addresses.city</code>.
     */
    public AddressesRecord setCity(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.addresses.city</code>.
     */
    public String getCity() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.addresses.state</code>.
     */
    public AddressesRecord setState(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.addresses.state</code>.
     */
    public String getState() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.addresses.zip</code>.
     */
    public AddressesRecord setZip(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.addresses.zip</code>.
     */
    public String getZip() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.addresses.country</code>.
     */
    public AddressesRecord setCountry(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.addresses.country</code>.
     */
    public String getCountry() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Addresses.ADDRESSES.ID;
    }

    @Override
    public Field<String> field2() {
        return Addresses.ADDRESSES.STREET;
    }

    @Override
    public Field<String> field3() {
        return Addresses.ADDRESSES.CITY;
    }

    @Override
    public Field<String> field4() {
        return Addresses.ADDRESSES.STATE;
    }

    @Override
    public Field<String> field5() {
        return Addresses.ADDRESSES.ZIP;
    }

    @Override
    public Field<String> field6() {
        return Addresses.ADDRESSES.COUNTRY;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getStreet();
    }

    @Override
    public String component3() {
        return getCity();
    }

    @Override
    public String component4() {
        return getState();
    }

    @Override
    public String component5() {
        return getZip();
    }

    @Override
    public String component6() {
        return getCountry();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getStreet();
    }

    @Override
    public String value3() {
        return getCity();
    }

    @Override
    public String value4() {
        return getState();
    }

    @Override
    public String value5() {
        return getZip();
    }

    @Override
    public String value6() {
        return getCountry();
    }

    @Override
    public AddressesRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public AddressesRecord value2(String value) {
        setStreet(value);
        return this;
    }

    @Override
    public AddressesRecord value3(String value) {
        setCity(value);
        return this;
    }

    @Override
    public AddressesRecord value4(String value) {
        setState(value);
        return this;
    }

    @Override
    public AddressesRecord value5(String value) {
        setZip(value);
        return this;
    }

    @Override
    public AddressesRecord value6(String value) {
        setCountry(value);
        return this;
    }

    @Override
    public AddressesRecord values(Long value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressesRecord
     */
    public AddressesRecord() {
        super(Addresses.ADDRESSES);
    }

    /**
     * Create a detached, initialised AddressesRecord
     */
    public AddressesRecord(Long id, String street, String city, String state, String zip, String country) {
        super(Addresses.ADDRESSES);

        setId(id);
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
        setCountry(country);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised AddressesRecord
     */
    public AddressesRecord(com.sivalabs.bookmarks.jooq.tables.pojos.Addresses value) {
        super(Addresses.ADDRESSES);

        if (value != null) {
            setId(value.getId());
            setStreet(value.getStreet());
            setCity(value.getCity());
            setState(value.getState());
            setZip(value.getZip());
            setCountry(value.getCountry());
            resetChangedOnNotNull();
        }
    }
}
