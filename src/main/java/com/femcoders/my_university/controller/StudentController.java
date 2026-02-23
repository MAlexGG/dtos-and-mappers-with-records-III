package com.femcoders.my_university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femcoders.my_university.dto.SchoolResponseDTO;
import com.femcoders.my_university.dto.StudentResponseDTO;
import com.femcoders.my_university.service.StudentService;

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

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        StudentResponseDTO student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @GetMapping("/school/{schoolName}")
    public ResponseEntity<SchoolResponseDTO> getStudentsBySchool(@PathVariable String schoolName) {
        SchoolResponseDTO response = studentService.getStudentsBySchool(schoolName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
