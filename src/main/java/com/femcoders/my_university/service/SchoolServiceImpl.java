package com.femcoders.my_university.service;


import org.springframework.stereotype.Service;

import com.femcoders.my_university.entity.School;
import com.femcoders.my_university.repository.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School getSchoolByName(String name) {
        School school = schoolRepository.findByName(name);
        if(school == null) throw new RuntimeException("No existe esta escuela");
        return school;
    }

   

}
