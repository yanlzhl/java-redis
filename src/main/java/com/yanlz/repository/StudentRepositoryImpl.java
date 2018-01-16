package com.yanlz.repository;

import com.yanlz.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;


/**
 * @author yanlz
 * @date 2018/01/16
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {
 
    private static final String KEY = "Student";

    private RedisTemplate<String, Student> redisTemplate;

    private HashOperations hashOps;

    public StudentRepositoryImpl() {
    }

    @Autowired
    private StudentRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
 
    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    @Override
    public void saveStudent(Object student) {
        hashOps.put(KEY, ((Student)student).getId(), student);
    }

    @Override
    public void updateStudent(Student student) {
        hashOps.put(KEY, student.getId(), student);
    }

    @Override
    public Object findStudent(String id) {
        return hashOps.get(KEY, id);
    }

    @Override
    public Map<Object, Object> findAllStudents() {

        return hashOps.entries(KEY);
    }

    @Override
    public void deleteStudent(String id) {

        hashOps.delete(KEY, id);
    }

    @Override
    public Object setValue(String name,String value) {
        hashOps.put(KEY,name,value);
        return hashOps.get(KEY,name);
    }
}