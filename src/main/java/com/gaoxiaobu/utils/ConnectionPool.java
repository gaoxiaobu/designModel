package com.gaoxiaobu.utils;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static BoneCP boneCp = null;
    private static BoneCPConfig boneCPConfig = null;

    static{
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
            boneCPConfig = new BoneCPConfig ();
            String jdbcUrl = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            boneCPConfig.setJdbcUrl (jdbcUrl);
            boneCPConfig.setUser ("root");
            boneCPConfig.setPassword ("root");
            // 数据库连接池的最小连接数
            boneCPConfig.setMinConnectionsPerPartition(5);
            // 数据库连接池的最大连接数
            boneCPConfig.setMaxConnectionsPerPartition(10);
            boneCPConfig.setPartitionCount(1);
            // System.out.println("boneCPConfig"+boneCPConfig);
        }catch(ClassNotFoundException e){
            e.printStackTrace ();
        }
    }

    // 获取连接池
    public static BoneCP getBoneCP() {
        try {
            boneCp = new BoneCP(boneCPConfig);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return boneCp;
    }

    //获取连接
    public static Connection getConnection(BoneCP boneCP){
        if (boneCP!=null){
            try{
                return boneCP.getConnection ();
            }catch(SQLException e){
                e.printStackTrace ();
            }
            return null;
        }else {
            return null;
        }
    }
    // 关闭连接池
    public static void closeBoneCP(BoneCP bc) {
        bc.close();
    }

    // 关闭连接
    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    public static DSLContext getContext(Connection conDsl) {
        return DSL.using(conDsl);
    }
}
