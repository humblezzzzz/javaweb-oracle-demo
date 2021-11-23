package com.chen.web.service.impl;

import com.chen.web.dao.Impl.StudentDaoImpl;
import com.chen.web.dao.StudentDao;
import com.chen.web.entity.StudentEntity;
import com.chen.web.service.StudentService;

import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/18 16:18
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao= new StudentDaoImpl();
    @Override
    public List<StudentEntity> studentList() {
        return studentDao.studentList();
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDao.deleteStudent(id)==1;
      }

    @Override
    public boolean addStudent(StudentEntity studentEntity) {
        return studentDao.addStudent(studentEntity)==1;
    }

    @Override
    public List<StudentEntity> getStudentList(String name) {
        return studentDao.getStudentList(name);
    }

    @Override
    public StudentEntity getById(String id) {
        return studentDao.getById(id);
    }

    @Override
    public boolean updateStudent(StudentEntity studentEntity) {
        return studentDao.updateStudent(studentEntity)==1;
    }
}
