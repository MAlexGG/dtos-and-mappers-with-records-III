package com.femcoders.my_university.service;

import java.util.List;

import com.femcoders.my_university.entity.Student;

public interface StudentService {

    //GET STUDENTS BY SCHOOL
    public List<Student> getStudentsBySchool(String name);

}
