package com.chen.web.util;

import java.sql.*;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/16 8:57
 */
public class jdbcUtil {
    static String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    static String user = "scott";
    static String password = "tiger";

    /**
     * 获取Connection对象
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("成功连接数据库");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not find !", e);
        } catch (SQLException e) {
            throw new RuntimeException("get connection error!", e);
        }
    }

    /**
     * 释放资源
     */
    public static void ReleaseResource(Connection connection, PreparedStatement pstm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
