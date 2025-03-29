package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.StudentDAO;
import com.example.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDao; // Delegate database operations to DAO

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents(); // Delegating to DAO
    }

    @Override
    public void addStudent(Student student) {
        studentDao.saveStudent(student); // Delegating to DAO
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id); // Delegating to DAO
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student); // Delegating to DAO
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id); // Delegating to DAO
    }
}
