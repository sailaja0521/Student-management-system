package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Display all students
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list-students";  // This will return list-student.jsp
    }

    // Display form for adding a new student
    @GetMapping("/students/addStudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());  // Empty student object for form
        return "add-student";  // This will return add-student.jsp
    }

    // Save a new student
    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);  // Call service method to save the student
        return "redirect:/students";  // Redirect to student list after saving
    }

    // Display form for editing an existing student
    @GetMapping("/students/editStudent/{id}")
    public String showEditStudentForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";  // This will return edit-student.jsp
    }

    // Update an existing student
    @PostMapping("/students/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";  // Redirect to student list after updating
    }

    @GetMapping("/students/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);  // Call service method to delete the student
        return "redirect:/students";      // Redirect back to the student list
    }
}
