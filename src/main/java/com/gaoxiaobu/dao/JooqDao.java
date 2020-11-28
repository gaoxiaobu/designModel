package com.gaoxiaobu.dao;

import com.gaoxiaobu.generated.tables.Author_;
import com.gaoxiaobu.utils.ConnectionPool;
import com.jolbox.bonecp.BoneCP;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static com.gaoxiaobu.generated.Tables.AUTHOR_;

@Api(tags = "jooq操作数据库")
public class JooqDao {
    private DSLContext dslContext = getDslContext ();
    private DSLContext getDslContext(){
        BoneCP boneCP = ConnectionPool.getBoneCP ();
        Connection connection = ConnectionPool.getConnection (boneCP);
        return dslContext = DSL.using (connection);
    }

    public void select(String select){
        Result<Record> rs = dslContext.select ().from ("author_").where (AUTHOR_.FIRST_NAME.eq (select)).fetch ();
        rs.forEach (record -> {
            System.out.println(record.getValue (AUTHOR_.ID));
            System.out.println(record.getValue (AUTHOR_.FIRST_NAME));
            System.out.println(record.getValue (AUTHOR_.LAST_NAME));
        });
        /*//SQL执行器
        dslContext = getDslContext ();
        Table<Record> author_ = DSL.table ("author_");
        //获取查询对象
        SelectQuery<Record> selectQuery = dslContext.selectQuery (author_);
        //查询条件
        LikeEscapeStep first_name = DSL.field ("first_name").like (select);
        //添加查询条件
        selectQuery.addConditions (first_name);
        *//*record是jOOQ定义的用于储存数据库结果记录的一个接口，
         其主要是将一个表字段的列表和值的列表使用相同的顺序储存在一起，
         可以看做是一个用于储存列/值的映射的对象。
         通常有以下几种形式
         Result:结果集接口
         *//*
        Result<Record> rs = selectQuery.fetch ();

        for (Object author :rs){
            *//*Record:此接口再使用关系型数据库时，主要用于定义数据库表记录，
            储存的内容是一条表记录的字段和值，每个值会储存对应字段的类型，
            可以通过通用的 getValue(Field field) 方法，取到对应字段的值，
            也可以将这个接口看做是一条记录的字段/值映射*//*
            Record record = (Record)author;
            System.out.println(record);
            System.out.println(record.getValue ("firstName"));
        }*/
    }

    public void selectAll(){
        Result<Record> fetchResult = dslContext.select().from(AUTHOR_).fetch();
        fetchResult.forEach (record ->{
            Integer id = record.getValue (AUTHOR_.ID);
            String firstName = record.getValue (AUTHOR_.FIRST_NAME);
            String lastName = record.getValue (AUTHOR_.LAST_NAME);
            System.out.println(id+"-----"+firstName+"-----"+lastName);
        });
    }

    public void selectOne(Integer id){
        Result<Record1<Integer>> fetch = dslContext.selectOne ().from (AUTHOR_).where (AUTHOR_.ID.eq (id)).fetch ();
        fetch.forEach (integerRecord1 -> {
            Integer v = integerRecord1.getValue (AUTHOR_.ID);
            String firstName = integerRecord1.getValue (AUTHOR_.FIRST_NAME);
            String lastName = integerRecord1.getValue (AUTHOR_.LAST_NAME);
            System.out.println(v+"-----"+firstName+"-----"+lastName);
        });
    }

    public void selectLike(String name){
        Result<Record> fetch = dslContext.select ().from ().where (AUTHOR_.FIRST_NAME.like (name)).fetch ();
        fetch.forEach (record -> {
            Integer value = record.getValue (AUTHOR_.ID);
            String firstName = record.getValue (AUTHOR_.FIRST_NAME);
            String lastName = record.getValue (AUTHOR_.LAST_NAME);
            System.out.println(value+"-----"+firstName+"-----"+lastName);
        });
    }

    public void update(String name){
        dslContext = getDslContext ();
        Table<Record> table = DSL.table ("author_");
        //获取更新对象
        UpdateQuery<Record> updateQuery = dslContext.updateQuery (table);
        //更新first_name字段的值为firstname
        updateQuery.addValue (DSL.field ("first_name"),"杰伊");
        Condition condition = DSL.field ("first_name").eq (name);

        updateQuery.addValue (DSL.field ("last_name"),"盖茨比");
        Condition last_name = DSL.field ("last_name").eq (name);
        //updateQuery.addConditions (last_name);
        updateQuery.addConditions (condition);
        int execute = updateQuery.execute ();
        System.out.println(execute);
        select ("s");
    }

    public void delete(Integer id){
        dslContext = getDslContext ();
        Table<Record> author_ = DSL.table ("author_");
        DeleteQuery<Record> deleteQuery = dslContext.deleteQuery (author_);
        deleteQuery.addLimit (1);
        Condition condition = DSL.field ("id").eq (id);
        deleteQuery.addConditions (condition);
        int execute = deleteQuery.execute ();
        System.out.println(execute);
    }
}
