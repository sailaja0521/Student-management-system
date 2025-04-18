package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // No need to define delete method; JpaRepository provides deleteById method
}

