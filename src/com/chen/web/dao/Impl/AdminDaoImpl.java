package com.chen.web.dao.Impl;

import com.chen.web.dao.AdminDao;
import com.chen.web.entity.AdminEntity;
import com.chen.web.util.jdbcUtil;
import oracle.jdbc.internal.OraclePreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/18 9:15
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public AdminEntity getAdminByUserName(String userName) {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from admin where userName=?");
        try {
            ps = connection.prepareStatement(stringBuilder.toString());
            //第一个?的参数
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                int aid = rs.getInt("aid");
                String name = rs.getString("userName");
                String password = rs.getString("password");
                AdminEntity adminEntity = new AdminEntity();
                adminEntity.setAid(aid);
                adminEntity.setUsername(name);
                adminEntity.setPassword(password);
                return adminEntity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.ReleaseResource(connection, ps, rs);
        }
        return null;
    }
}
