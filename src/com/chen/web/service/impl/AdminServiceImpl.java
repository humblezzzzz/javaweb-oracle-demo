package com.chen.web.service.impl;

import com.chen.web.dao.AdminDao;
import com.chen.web.dao.Impl.AdminDaoImpl;
import com.chen.web.entity.AdminEntity;
import com.chen.web.service.AdminService;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/18 8:51
 */
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public AdminEntity getAdminByUserName(String userName) {
        return adminDao.getAdminByUserName(userName);
    }
}
