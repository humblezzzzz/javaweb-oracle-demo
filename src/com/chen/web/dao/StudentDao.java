package com.chen.web.dao;

import com.chen.web.entity.StudentEntity;

import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/18 16:17
 */
public interface StudentDao {
    List<StudentEntity> studentList();

    int deleteStudent(String id);

    int addStudent(StudentEntity studentEntity);

    List<StudentEntity> getStudentList(String name);

    StudentEntity getById(String id);

    int updateStudent(StudentEntity studentEntity);
}
