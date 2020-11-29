package learn_jooq.gaoxiaobu.service.impl;

import learn_jooq.gaoxiaobu.generated.tables.pojos.S1User;
import learn_jooq.gaoxiaobu.generated.tables.records.S1UserRecord;
import learn_jooq.gaoxiaobu.service.ManagerService;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static learn_jooq.gaoxiaobu.generated.tables.S1User.S1_USER;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private DSLContext dslContext;
    private static Connection connection = null;

    static {
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String userName = "root";
            String password = "root";
            connection = DriverManager.getConnection (jdbcUrl, userName, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public List<S1User> s_1_userList() {
        List<S1User> s1Users = dslContext.select ().from (S1_USER).fetchInto (S1User.class);
        List<S1User> rs = new ArrayList<> ();
        for (S1User sUser:s1Users) {
            S1User s1User = new S1User ();
            s1User.setId (sUser.getId ());
            s1User.setUsername (sUser.getUsername ());
            s1User.setAddress (sUser.getAddress ());
            s1User.setEmail (sUser.getEmail ());
            s1User.setCreateTime (sUser.getCreateTime ());
            s1User.setUpdateTime (sUser.getUpdateTime ());
            rs.add (s1User);
        }
        return rs;
    }

    /**
     * 保存当前用户信息
     * @param user
     * @return
     */
    @Override
    public String save(S1User user) {
        dslContext
                .insertInto (S1_USER,S1_USER.ID,S1_USER.ADDRESS,S1_USER.CREATE_TIME,S1_USER.EMAIL,S1_USER.UPDATE_TIME,S1_USER.USERNAME)
                .values (user.getId (),user.getAddress (),user.getCreateTime (),user.getEmail (),user.getUpdateTime (),user.getUsername ())
                .execute ();
        return "success";
    }

    @Override
    public int update(S1User user) {
        UpdateQuery<S1UserRecord> updateQuery = dslContext.updateQuery (S1_USER);
        updateQuery.addValue (S1_USER.ADDRESS,user.getAddress ());
        Condition cond = DSL.field (S1_USER.ID).eq (user.getId ());
        updateQuery.addConditions (cond);
        return updateQuery.execute ();
    }

    @Override
    public int updateDetach(S1User user) {
        DSLContext using = DSL.using (connection);

        return using.update (S1_USER)
                .set (S1_USER.ADDRESS, user.getAddress ())
                .set (S1_USER.EMAIL,user.getEmail ())
                .set (S1_USER.USERNAME,user.getUsername ())
                .where (DSL.field (S1_USER.ID)
                .eq (user.getId ()))
                .execute ();
    }

    public int delete(int id){
        return DSL.using (connection)
               .delete (S1_USER)
               .where (DSL.field (S1_USER.ID)
                       .eq (id))
               .execute ();
    }

    @Override
    public List<S1User> s1_userListAndPage(int page, int offSet) {
        List<S1User> s1Users = DSL.using (connection).select ().from (S1_USER).limit (page, offSet).fetchInto (S1User.class);
        for (S1User sUser: s1Users) {
            System.out.println(sUser.getId ());
            System.out.println(sUser.getAddress ());
            System.out.println(sUser.getEmail ());
            System.out.println(sUser.getUsername ());
        }
        return s1Users;
    }

    @Override
    public int deleteDetach(List<Integer> ids) {
        return 1;
    }

    @Override
    public boolean insertBatch(List<S1User> s1UserList) {
        return false;
    }

    /**
     * 查询单条记录
     * @param id
     * @return
     */
    @Override
    public S1User selectOne(int id) {
        Result<Record1<Integer>> fetch = DSL.using (connection).selectOne ().from (S1_USER).where (S1_USER.ID.eq (id)).fetch ();

        List<S1User> values = (List<S1User>) fetch.getValues (0);

        S1User s1User1 = values.get (0);

        for (S1User s1User:values) {
            System.out.println(s1User.getUsername ());
            System.out.println(s1User.getAddress ());
            System.out.println(s1User.getCreateTime ());
            System.out.println(s1User.getUpdateTime ());
        }

        return s1User1;

    }


}
