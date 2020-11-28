/*
 * This file is generated by jOOQ.
 */
package learn_jooq.gaoxiaobu.generated.tables.records;


import java.time.LocalDateTime;

import learn_jooq.gaoxiaobu.generated.tables.S4NoPrimary;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S4NoPrimaryRecord extends TableRecordImpl<S4NoPrimaryRecord> implements Record4<String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>learn-jooq.s4_no_primary.column1</code>. 测试列1
     */
    public void setColumn1(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>learn-jooq.s4_no_primary.column1</code>. 测试列1
     */
    public String getColumn1() {
        return (String) get(0);
    }

    /**
     * Setter for <code>learn-jooq.s4_no_primary.column2</code>. 测试列2
     */
    public void setColumn2(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>learn-jooq.s4_no_primary.column2</code>. 测试列2
     */
    public String getColumn2() {
        return (String) get(1);
    }

    /**
     * Setter for <code>learn-jooq.s4_no_primary.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>learn-jooq.s4_no_primary.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>learn-jooq.s4_no_primary.update_time</code>. 更新时间
     */
    public void setUpdateTime(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>learn-jooq.s4_no_primary.update_time</code>. 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return S4NoPrimary.S4_NO_PRIMARY.COLUMN1;
    }

    @Override
    public Field<String> field2() {
        return S4NoPrimary.S4_NO_PRIMARY.COLUMN2;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return S4NoPrimary.S4_NO_PRIMARY.CREATE_TIME;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return S4NoPrimary.S4_NO_PRIMARY.UPDATE_TIME;
    }

    @Override
    public String component1() {
        return getColumn1();
    }

    @Override
    public String component2() {
        return getColumn2();
    }

    @Override
    public LocalDateTime component3() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime component4() {
        return getUpdateTime();
    }

    @Override
    public String value1() {
        return getColumn1();
    }

    @Override
    public String value2() {
        return getColumn2();
    }

    @Override
    public LocalDateTime value3() {
        return getCreateTime();
    }

    @Override
    public LocalDateTime value4() {
        return getUpdateTime();
    }

    @Override
    public S4NoPrimaryRecord value1(String value) {
        setColumn1(value);
        return this;
    }

    @Override
    public S4NoPrimaryRecord value2(String value) {
        setColumn2(value);
        return this;
    }

    @Override
    public S4NoPrimaryRecord value3(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public S4NoPrimaryRecord value4(LocalDateTime value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public S4NoPrimaryRecord values(String value1, String value2, LocalDateTime value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached S4NoPrimaryRecord
     */
    public S4NoPrimaryRecord() {
        super(S4NoPrimary.S4_NO_PRIMARY);
    }

    /**
     * Create a detached, initialised S4NoPrimaryRecord
     */
    public S4NoPrimaryRecord(String column1, String column2, LocalDateTime createTime, LocalDateTime updateTime) {
        super(S4NoPrimary.S4_NO_PRIMARY);

        setColumn1(column1);
        setColumn2(column2);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
    }
}
