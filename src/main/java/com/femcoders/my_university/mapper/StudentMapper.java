package com.femcoders.my_university.mapper;

import org.mapstruct.Mapper;

import com.femcoders.my_university.dto.StudentResponseDTO;
import com.femcoders.my_university.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDTO toResponseDTO(Student student);
}
