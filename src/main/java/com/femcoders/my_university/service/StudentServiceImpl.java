package com.femcoders.my_university.service;

import org.springframework.stereotype.Service;

import com.femcoders.my_university.dto.request.StudentRequestDTO;
import com.femcoders.my_university.dto.response.SchoolResponseDTO;
import com.femcoders.my_university.dto.response.StudentResponseDTO;
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
        /* Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) throw new RuntimeException("No existe estudiante"); */

        //Para evitar usar Optional podemos usar orElseThrow y llamar a los 
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        StudentResponseDTO response = studentMapper.toResponseDTO(student);
        return response;
    }

    @Override
    public SchoolResponseDTO getStudentsBySchool(String name) {
        School school = schoolService.getSchoolByName(name);
        if(school == null) throw new RuntimeException("No existe esa escuela");
        SchoolResponseDTO response = schoolMapper.toResponseDTO(school);
        return response;
    }

    @Override
    public Student createStudent(StudentRequestDTO studentDto, String schoolName) {
        School school = schoolService.getSchoolByName(schoolName);
        Student student = studentMapper.toEntity(studentDto);
        student.setSchool(school);
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }

    

}
