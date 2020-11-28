package com.gaoxiaobu;



import static com.gaoxiaobu.generated.tables.pojos.Author_.*;

import com.gaoxiaobu.dao.JooqDao;
import com.gaoxiaobu.generated.tables.pojos.Author_;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest(classes = JooqTestApplication.class)
@RunWith(SpringRunner.class)
public class testJooq {
    @Test
    public void testJooq(){
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
        try(Connection con = DriverManager.getConnection (url,userName,password)){
            DSLContext dslContext = DSL.using (con, SQLDialect.MYSQL);
            Result<Record> fetch = dslContext.select().from(com.gaoxiaobu.generated.tables.Author_.AUTHOR_).fetch();

            for (Record r:fetch){
                int id = r.getValue (com.gaoxiaobu.generated.tables.Author_.AUTHOR_.ID);
                String firstName = r.getValue (com.gaoxiaobu.generated.tables.Author_.AUTHOR_.FIRST_NAME);
                String lastName = r.getValue (com.gaoxiaobu.generated.tables.Author_.AUTHOR_.LAST_NAME);
                /**
                 * 控制台输出
                 * ID: 1 first name: 3 last name: zhang
                 * ID: 2 first name: 4 last name: li
                 */
                System.out.println("ID:"+id + "firstName"+ firstName + "lastName: " + lastName);
            }

            con.close ();

        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
    @Test
    public void testJooq2(){
        String select = "s";
        JooqDao jooqDao = new JooqDao ();
        jooqDao.select (select);

        /*jooqDao.update ("李四");

        jooqDao.delete (1);*/

        //jooqDao.selectAll ();

    }
}
