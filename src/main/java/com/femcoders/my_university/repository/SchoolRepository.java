package com.femcoders.my_university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femcoders.my_university.entity.School;


public interface SchoolRepository extends JpaRepository<School, Integer> {
    public School findByName(String name); 
}
