package com.femcoders.my_university.seeder;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.femcoders.my_university.entity.School;
import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.repository.SchoolRepository;
import com.femcoders.my_university.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public void run(String... args) throws Exception {
        if(schoolRepository.count() == 0){
            School architecture_school = School.builder()
            .name("Architecture")
            .build();

            School engineering_school = School.builder()
            .name("Engineering")
            .build();

            schoolRepository.saveAll(List.of(architecture_school, engineering_school));
        }

        if(studentRepository.count() == 0){
            Student student_one = Student.builder()
            .name("Eli")
            .lastname("Gallardo")
            .dni_nie("70813942Y")
            .phone(675359811)
            .email("eli@mail.com")
            .school(schoolRepository.findByName("Architecture"))
            .build();

            Student student_two = Student.builder()
            .name("Gaby")
            .lastname("Galarza")
            .dni_nie("80311931E")
            .phone(625269925)
            .email("gabi@mail.com")
            .school(schoolRepository.findByName("Engineering"))
            .build();

            Student student_three = Student.builder()
            .name("John")
            .lastname("Doe")
            .dni_nie("20322939A")
            .phone(635220931)
            .email("john@mail.com")
            .school(schoolRepository.findByName("Engineering"))
            .build();

            studentRepository.saveAll(List.of(student_one, student_two, student_three));
        }
    }

}
