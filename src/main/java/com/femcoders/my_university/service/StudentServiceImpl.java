package com.femcoders.my_university.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.femcoders.my_university.dto.SchoolResponseDTO;
import com.femcoders.my_university.dto.StudentResponseDTO;
import com.femcoders.my_university.entity.School;
import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.mapper.SchoolMapper;
import com.femcoders.my_university.mapper.StudentMapper;
import com.femcoders.my_university.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final SchoolService schoolService;
    private final SchoolMapper schoolMapper;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolService schoolService, StudentMapper studentMapper, SchoolMapper schoolMapper){
        this.studentRepository = studentRepository;
        this.schoolService = schoolService;
        this.studentMapper = studentMapper;
        this.schoolMapper = schoolMapper;
    }

    @Override
    public StudentResponseDTO getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) throw new RuntimeException("No existe estudiante");
        StudentResponseDTO response = studentMapper.toResponseDTO(student.get());
        return response;
    }

    @Override
    public SchoolResponseDTO getStudentsBySchool(String name) {
        School school = schoolService.getSchoolByName(name);
        if(school == null) throw new RuntimeException("No existe esa escuela");
        //List<Student> students = studentRepository.findBySchool(school);
        SchoolResponseDTO response = schoolMapper.toResponseDTO(school);
        return response;
    }

    

}
