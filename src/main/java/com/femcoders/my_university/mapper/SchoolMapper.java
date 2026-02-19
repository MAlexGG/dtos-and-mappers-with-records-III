package com.femcoders.my_university.mapper;

import org.mapstruct.Mapper;

import com.femcoders.my_university.dto.SchoolResponseDTO;
import com.femcoders.my_university.entity.School;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface SchoolMapper {

    SchoolResponseDTO toResponseDTO(School school);
}
