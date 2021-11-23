package com.chen.web.service;

import com.chen.web.entity.StudentEntity;

import java.util.List;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/18 16:18
 */
public interface StudentService {
    List<StudentEntity> studentList();

    boolean deleteStudent(String id);

    boolean addStudent(StudentEntity studentEntity);

    List<StudentEntity> getStudentList(String name);

    StudentEntity getById(String id);

    boolean updateStudent(StudentEntity studentEntity);

}
