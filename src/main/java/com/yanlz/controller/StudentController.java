package com.yanlz.controller;

import com.yanlz.bean.Student;
import com.yanlz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanlz
 * @date 2018/01/16
 */
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/index")
    public String index(){
        return "hello!";
    }

    @RequestMapping("/save")
    public Student save(){
        Student student = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.saveStudent(student);
        return student;
    }

    @RequestMapping("/findOne")
    public Object findOne(){
        return  studentRepository.findStudent("Eng2015001");
    }

//    @RequestMapping("/update")
//    public Object update(){
//        Object retrievedStudent = studentRepository.findStudent("Eng2015001");
//        retrievedStudent.setName("Richard Watson");
//
//        studentRepository.saveStudent(retrievedStudent);
//        return studentRepository.findStudent("Eng2015001");
//    }

    @RequestMapping("/delete")
    public void delete(){
        studentRepository.deleteStudent("Eng2015001");
    }

    @RequestMapping("/findAll")
    public Map<Object, Object> findAll(){
        Student engStudent =
                new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent =
                new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.saveStudent(engStudent);
        studentRepository.saveStudent(medStudent);

        return studentRepository.findAllStudents();
    }

    @GetMapping("/setValue")
    public Object setValue(String name,String value){
        return studentRepository.setValue(name,value);
    }



}
