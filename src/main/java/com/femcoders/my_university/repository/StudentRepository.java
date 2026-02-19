package com.femcoders.my_university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femcoders.my_university.entity.School;
import com.femcoders.my_university.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findBySchool(School school);

}
