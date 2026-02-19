package com.femcoders.my_university.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.femcoders.my_university.entity.School;
import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolService schoolService;


    public StudentServiceImpl(StudentRepository studentRepository, SchoolService schoolService){
        this.studentRepository = studentRepository;
        this.schoolService = schoolService;
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) throw new RuntimeException("No existe estudiante");
        return student.get();
    }

    @Override
    public List<Student> getStudentsBySchool(String name) {
        School school = schoolService.getSchoolByName(name);
        return studentRepository.findBySchool(school);
    }

    

}
