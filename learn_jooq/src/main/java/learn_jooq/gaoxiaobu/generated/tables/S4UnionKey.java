/*
 * This file is generated by jOOQ.
 */
package learn_jooq.gaoxiaobu.generated.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import learn_jooq.gaoxiaobu.generated.Keys;
import learn_jooq.gaoxiaobu.generated.LearnJooq;
import learn_jooq.gaoxiaobu.generated.tables.records.S4UnionKeyRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
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
public class S4UnionKey extends TableImpl<S4UnionKeyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>learn-jooq.s4_union_key</code>
     */
    public static final S4UnionKey S4_UNION_KEY = new S4UnionKey();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<S4UnionKeyRecord> getRecordType() {
        return S4UnionKeyRecord.class;
    }

    /**
     * The column <code>learn-jooq.s4_union_key.uk_1</code>. 联合ID1
     */
    public final TableField<S4UnionKeyRecord, Integer> UK_1 = createField(DSL.name("uk_1"), SQLDataType.INTEGER.nullable(false), this, "联合ID1");

    /**
     * The column <code>learn-jooq.s4_union_key.uk_2</code>. 联合ID2
     */
    public final TableField<S4UnionKeyRecord, Integer> UK_2 = createField(DSL.name("uk_2"), SQLDataType.INTEGER.nullable(false), this, "联合ID2");

    /**
     * The column <code>learn-jooq.s4_union_key.create_time</code>. 创建时间
     */
    public final TableField<S4UnionKeyRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>learn-jooq.s4_union_key.update_time</code>. 更新时间
     */
    public final TableField<S4UnionKeyRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "更新时间");

    private S4UnionKey(Name alias, Table<S4UnionKeyRecord> aliased) {
        this(alias, aliased, null);
    }

    private S4UnionKey(Name alias, Table<S4UnionKeyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>learn-jooq.s4_union_key</code> table reference
     */
    public S4UnionKey(String alias) {
        this(DSL.name(alias), S4_UNION_KEY);
    }

    /**
     * Create an aliased <code>learn-jooq.s4_union_key</code> table reference
     */
    public S4UnionKey(Name alias) {
        this(alias, S4_UNION_KEY);
    }

    /**
     * Create a <code>learn-jooq.s4_union_key</code> table reference
     */
    public S4UnionKey() {
        this(DSL.name("s4_union_key"), null);
    }

    public <O extends Record> S4UnionKey(Table<O> child, ForeignKey<O, S4UnionKeyRecord> key) {
        super(child, key, S4_UNION_KEY);
    }

    @Override
    public Schema getSchema() {
        return LearnJooq.LEARN_JOOQ;
    }

    @Override
    public UniqueKey<S4UnionKeyRecord> getPrimaryKey() {
        return Keys.KEY_S4_UNION_KEY_PRIMARY;
    }

    @Override
    public List<UniqueKey<S4UnionKeyRecord>> getKeys() {
        return Arrays.<UniqueKey<S4UnionKeyRecord>>asList(Keys.KEY_S4_UNION_KEY_PRIMARY);
    }

    @Override
    public S4UnionKey as(String alias) {
        return new S4UnionKey(DSL.name(alias), this);
    }

    @Override
    public S4UnionKey as(Name alias) {
        return new S4UnionKey(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public S4UnionKey rename(String name) {
        return new S4UnionKey(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public S4UnionKey rename(Name name) {
        return new S4UnionKey(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
