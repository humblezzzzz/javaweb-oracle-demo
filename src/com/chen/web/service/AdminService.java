package com.chen.web.service;

import com.chen.web.entity.AdminEntity;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/18 8:51
 */
public interface AdminService {
    AdminEntity getAdminByUserName(String userName);
}
