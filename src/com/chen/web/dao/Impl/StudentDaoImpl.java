package com.chen.web.dao.Impl;

import com.chen.web.dao.StudentDao;
import com.chen.web.entity.StudentEntity;
import com.chen.web.util.jdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/18 16:18
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<StudentEntity> studentList() {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from STUDENT");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            rs = ps.executeQuery();
            List<StudentEntity> list = new ArrayList<>();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                String no = rs.getString("no");
                Date birthDay = rs.getDate("brithDay");
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setSdi(sid);
                studentEntity.setName(name);
                studentEntity.setNo(no);
                studentEntity.setDate(birthDay);
                list.add(studentEntity);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return null;
    }

    @Override
    public int deleteStudent(String id) {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete from student where sid=?");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            ps.setString(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return 0;
    }

    @Override
    public int addStudent(StudentEntity studentEntity) {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("insert into student values(ADMIN_SEQUENCES.NEXTVAL,?,?,sysdate)");
        stringBuilder.append("insert into student values(ADMIN_SEQUENCES.NEXTVAL,?,?,?)");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            ps.setString(1, studentEntity.getName());
            ps.setString(2, studentEntity.getNo());
//            ps.setTimestamp(3,new Timestamp(studentEntity.getDate().getTime()));
            ps.setDate(3, new java.sql.Date(studentEntity.getDate().getTime()));
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return 0;
    }

    @Override
    public List<StudentEntity> getStudentList(String name) {
        if (name == null) {
            name = " ";
        }
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("SELECT * FROM student where name like ?");
        stringBuilder.append("SELECT * FROM student where name like ? order by sid desc");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            List<StudentEntity> list = new ArrayList<>();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String no = rs.getString("no");
                String name1 = rs.getString("name");
                Date birthDay = rs.getDate("brithDay");
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setSdi(sid);
                studentEntity.setName(name1);
                studentEntity.setNo(no);
                studentEntity.setDate(birthDay);
                list.add(studentEntity);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return null;
    }

    @Override
    public StudentEntity getById(String id) {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from STUDENT where sid=?");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                String no = rs.getString("no");
                Date birthDay = rs.getDate("brithDay");
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setSdi(sid);
                studentEntity.setName(name);
                studentEntity.setNo(no);
                studentEntity.setDate(birthDay);
                return studentEntity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return null;
    }

    @Override
    public int updateStudent(StudentEntity studentEntity) {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("update student set name=?,no=?,birthday=? where sid=?");
        stringBuilder.append("update student set name=?,no=?,brithday=? where sid =?");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            ps.setString(1, studentEntity.getName());
            ps.setString(2, studentEntity.getNo());
            ps.setDate(3, new java.sql.Date(studentEntity.getDate().getTime()));
            ps.setInt(4, studentEntity.getSdi());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return 0;
    }
}
