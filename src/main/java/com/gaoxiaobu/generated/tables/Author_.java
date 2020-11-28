/*
 * This file is generated by jOOQ.
 */
package com.gaoxiaobu.generated.tables;


import com.gaoxiaobu.generated.Keys;
import com.gaoxiaobu.generated.Library;
import com.gaoxiaobu.generated.tables.records.Author_Record;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Author_ extends TableImpl<Author_Record> {

    private static final long serialVersionUID = -1111499677;

    /**
     * The reference instance of <code>library.author_</code>
     */
    public static final Author_ AUTHOR_ = new Author_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Author_Record> getRecordType() {
        return Author_Record.class;
    }

    /**
     * The column <code>library.author_.id</code>.
     */
    public final TableField<Author_Record, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>library.author_.first_name</code>.
     */
    public final TableField<Author_Record, String> FIRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>library.author_.last_name</code>.
     */
    public final TableField<Author_Record, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * Create a <code>library.author_</code> table reference
     */
    public Author_() {
        this(DSL.name("author_"), null);
    }

    /**
     * Create an aliased <code>library.author_</code> table reference
     */
    public Author_(String alias) {
        this(DSL.name(alias), AUTHOR_);
    }

    /**
     * Create an aliased <code>library.author_</code> table reference
     */
    public Author_(Name alias) {
        this(alias, AUTHOR_);
    }

    private Author_(Name alias, Table<Author_Record> aliased) {
        this(alias, aliased, null);
    }

    private Author_(Name alias, Table<Author_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Author_(Table<O> child, ForeignKey<O, Author_Record> key) {
        super(child, key, AUTHOR_);
    }

    @Override
    public Schema getSchema() {
        return Library.LIBRARY;
    }

    @Override
    public UniqueKey<Author_Record> getPrimaryKey() {
        return Keys.KEY_AUTHOR__PRIMARY;
    }

    @Override
    public List<UniqueKey<Author_Record>> getKeys() {
        return Arrays.<UniqueKey<Author_Record>>asList(Keys.KEY_AUTHOR__PRIMARY);
    }

    @Override
    public Author_ as(String alias) {
        return new Author_(DSL.name(alias), this);
    }

    @Override
    public Author_ as(Name alias) {
        return new Author_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Author_ rename(String name) {
        return new Author_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author_ rename(Name name) {
        return new Author_(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
