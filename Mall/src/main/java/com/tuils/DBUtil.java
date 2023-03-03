package com.tuils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static DataSource ds = null;
    static{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/mall?useUnicode = true&characterEncoding=utf-8");
            cpds.setUser("root");
            cpds.setPassword("dyf5544181");
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(10);
            ds = cpds;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDs(){
        return ds;
    }
}
