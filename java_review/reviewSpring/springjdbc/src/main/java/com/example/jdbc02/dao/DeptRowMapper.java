package com.example.jdbc02.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DeptRowMapper implements RowMapper<Dept> {
    @Override
    public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dept dept = new Dept();
        dept.setId(rs.getInt("deptno"));
        dept.setDeptName(rs.getString("dname"));
        dept.setLocation(rs.getString("loc"));
        return dept;
    }
}
