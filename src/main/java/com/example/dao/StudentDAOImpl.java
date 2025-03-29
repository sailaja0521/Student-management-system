package com.example.dao;

import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    // Setter for sessionFactory (needed for Spring DI)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveStudent(Student student) {
        getCurrentSession().save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return getCurrentSession().createQuery("from Student", Student.class).list();
    }

    @Override
    public Student getStudentById(int id) {
        return getCurrentSession().get(Student.class, id);
    }

    @Override
    public void updateStudent(Student student) {
        getCurrentSession().update(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            getCurrentSession().delete(student);
        }
    }
}
