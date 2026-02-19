package com.femcoders.my_university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femcoders.my_university.dto.SchoolResponseDTO;
import com.femcoders.my_university.mapper.SchoolMapper;
import com.femcoders.my_university.service.SchoolService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final SchoolService schoolService;
    private final SchoolMapper schoolMapper;

    public StudentController(SchoolService schoolService, SchoolMapper schoolMapper){
        this.schoolService = schoolService;
        this.schoolMapper = schoolMapper;
    }

    @GetMapping("/{schoolName}")
    public ResponseEntity<SchoolResponseDTO> getStudentsBySchool(@PathVariable String schoolName) {
        var school = schoolService.getSchoolByName(schoolName);
        SchoolResponseDTO response = schoolMapper.toResponseDTO(school);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
