package com.femcoders.my_university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.service.StudentService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/{schoolName}")
    public ResponseEntity<List<Student>> getStudentsBySchool(@PathVariable String schoolName) {
        List<Student> students = studentService.getStudentsBySchool(schoolName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
}
