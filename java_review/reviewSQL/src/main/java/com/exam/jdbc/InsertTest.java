package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {
        // 1. 필요한 객체를 선언해줌.
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 3. 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl = "jdbc:mysql://localhost/test";
            String user = "root";
            String password = "1234";
            conn = DriverManager.getConnection(dburl, user, password);

            // 4. 쿼리 작성
            String sql = "insert into dept(deptno,dname,loc) values (70,'개발부','서울')";
            ps = conn.prepareStatement(sql);

            // 5. 실행
            int count = ps.executeUpdate();
            System.out.println(count +" insert complete");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 2.  닫아줌
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }

            }


        }
    }
}
