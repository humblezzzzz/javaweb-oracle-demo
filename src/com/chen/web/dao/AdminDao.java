package com.chen.web.dao;

import com.chen.web.entity.AdminEntity;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/18 9:15
 */
public interface AdminDao {
    AdminEntity getAdminByUserName(String userName);
}
