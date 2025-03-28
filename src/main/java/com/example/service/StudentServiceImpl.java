package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @PersistenceContext // Injects the EntityManager
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        // Retrieve all students from the database
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public void addStudent(Student student) {
        // Save the student to the database
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(int id) {
        // Retrieve a student by ID
        return entityManager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Student student) {
        // Update the student in the database
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(int id) {
        // Delete the student from the database
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
