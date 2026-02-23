package com.femcoders.my_university.service;

import com.femcoders.my_university.dto.SchoolResponseDTO;
import com.femcoders.my_university.dto.StudentResponseDTO;

public interface StudentService {

    //GET STUDENT BY ID
    public StudentResponseDTO getStudentById(int id);

    //GET STUDENTS BY SCHOOL
    public SchoolResponseDTO getStudentsBySchool(String name);


}
