package com.example.machinetets.controller;


import com.example.machinetets.models.Student;
import com.example.machinetets.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins ="http://localhost:5173")
public class StudentController {

    public final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
