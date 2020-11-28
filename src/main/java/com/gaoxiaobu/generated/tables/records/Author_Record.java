/*
 * This file is generated by jOOQ.
 */
package com.gaoxiaobu.generated.tables.records;


import com.gaoxiaobu.generated.tables.Author_;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Author_Record extends UpdatableRecordImpl<Author_Record> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 2107262765;

    /**
     * Setter for <code>library.author_.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>library.author_.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>library.author_.first_name</code>.
     */
    public void setFirstName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>library.author_.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>library.author_.last_name</code>.
     */
    public void setLastName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>library.author_.last_name</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Author_.AUTHOR_.ID;
    }

    @Override
    public Field<String> field2() {
        return Author_.AUTHOR_.FIRST_NAME;
    }

    @Override
    public Field<String> field3() {
        return Author_.AUTHOR_.LAST_NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFirstName();
    }

    @Override
    public String component3() {
        return getLastName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFirstName();
    }

    @Override
    public String value3() {
        return getLastName();
    }

    @Override
    public Author_Record value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public Author_Record value2(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public Author_Record value3(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public Author_Record values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Author_Record
     */
    public Author_Record() {
        super(Author_.AUTHOR_);
    }

    /**
     * Create a detached, initialised Author_Record
     */
    public Author_Record(Integer id, String firstName, String lastName) {
        super(Author_.AUTHOR_);

        set(0, id);
        set(1, firstName);
        set(2, lastName);
    }
}
