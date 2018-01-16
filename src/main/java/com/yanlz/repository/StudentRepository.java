package com.yanlz.repository;

import com.yanlz.bean.Student;

import java.util.Map;

public interface StudentRepository {
     
    void saveStudent(Object person);

    void updateStudent(Student student);

    Object findStudent(String id);

    Map<Object, Object> findAllStudents();

    void deleteStudent(String id);

    Object setValue(String name,String value);





}