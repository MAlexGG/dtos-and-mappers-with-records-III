package com.femcoders.my_university.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.femcoders.my_university.dto.request.StudentRequestDTO;
import com.femcoders.my_university.dto.response.StudentResponseDTO;
import com.femcoders.my_university.entity.Student;

//Para ignorar los campos no mapeados se puede poner un @Mapping por cada uno o añadir una política
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentResponseDTO toResponseDTO(Student student);

    /* @Mapping(target = "id", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "school", ignore = true) */
    Student toEntity(StudentRequestDTO studentRequestDTO);
}
