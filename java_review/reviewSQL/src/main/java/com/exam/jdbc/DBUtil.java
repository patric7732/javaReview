package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    // DB에 대한 커넥션 즉 접속을 하는 메서드
    public static Connection getConnection() throws Exception {
        Connection conn = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "1234";
        conn = DriverManager.getConnection(dbUrl, user, password);
        return conn;
    }

    public static Connection getConnection(String dbUrl, String user, String password) {
        Connection conn = null;

        return conn;
    }
    // close를 하는 메서드
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void close(Connection conn, PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn);
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn, ps);
    }
}
