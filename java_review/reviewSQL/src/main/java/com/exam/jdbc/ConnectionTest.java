package com.exam.jdbc;

// 0. 라이브러리 추가

// buidl.gradle에서 dependencies에 필요한 라이브러리 추가

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        // 0 - 1 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dburl = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "1234";

        // 1. 커넥션
        Connection conn = DriverManager.getConnection(dburl, user, password);

        if (conn != null) {
            System.out.println("connection complete");
        } else {
            System.out.println("connection failed");
        }
    }

    String dname = "개발부";

    //statement를 사용
//    String sql = "insert into dept(deptno, dname) values(3, '"+dname+"')";

    // 변역을 해줘야함! DBMS는 쿼라가 들어오면 번혁한다, 이때 같은 쿼리가 들어오면 이미 번역된 것을 이용한다.
    // 값이 바뀌어도 다른 쿼리로 인식한다. 그러니까 매번 번역한다.


    // 그러면 효율이 떨어짐, 그렇기에 preparedStatement를 쓰면
    String sql2 = "insert into dept(deptno, dname) values(3, ?)";
    // 여기까지 번역, 값이 나중에 바뀌므로 매번 번역하지 않는다, 문자열도 간결해짐. 성능도 좋아짐..
    // 그렇기에 prepare를 더 많이 씀
}
