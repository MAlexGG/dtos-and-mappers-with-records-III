package com.femcoders.my_university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femcoders.my_university.dto.SchoolResponseDTO;
import com.femcoders.my_university.dto.StudentResponseDTO;
import com.femcoders.my_university.entity.School;
import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.mapper.SchoolMapper;
import com.femcoders.my_university.mapper.StudentMapper;
import com.femcoders.my_university.service.SchoolService;
import com.femcoders.my_university.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;
    private final SchoolService schoolService;
    private final StudentMapper studentMapper;
    private final SchoolMapper schoolMapper;

    public StudentController(SchoolService schoolService, SchoolMapper schoolMapper,StudentService studentService, StudentMapper studentMapper){
        this.studentService = studentService;
        this.schoolService = schoolService;
        this.studentMapper = studentMapper;
        this.schoolMapper = schoolMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        StudentResponseDTO response = studentMapper.toResponseDTO(student);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/school/{schoolName}")
    public ResponseEntity<SchoolResponseDTO> getStudentsBySchool(@PathVariable String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        SchoolResponseDTO response = schoolMapper.toResponseDTO(school);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
