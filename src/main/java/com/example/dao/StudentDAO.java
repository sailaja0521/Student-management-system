package com.example.dao;

import com.example.model.Student;
import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student); // Method to save student data to the database

    List<Student> getAllStudents(); // Method to get the list of all students

    Student getStudentById(int id); // Method to fetch a student by their ID

    void updateStudent(Student student); // Method to update student details

    void deleteStudent(int id); // Method to delete a student by their ID
}

