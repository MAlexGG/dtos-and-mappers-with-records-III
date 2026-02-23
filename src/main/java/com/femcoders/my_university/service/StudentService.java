package com.femcoders.my_university.service;

import com.femcoders.my_university.dto.request.StudentRequestDTO;
import com.femcoders.my_university.dto.response.SchoolResponseDTO;
import com.femcoders.my_university.dto.response.StudentResponseDTO;
import com.femcoders.my_university.entity.Student;

public interface StudentService {

    //GET STUDENT BY ID
    public StudentResponseDTO getStudentById(int id);

    //GET STUDENTS BY SCHOOL
    public SchoolResponseDTO getStudentsBySchool(String name);

    //CREATE STUDENT
    public Student createStudent(StudentRequestDTO student,String schoolName);


}
