package com.femcoders.my_university.dto;

import java.util.List;

public record SchoolResponseDTO(Integer id, String name, List<StudentResponseDTO> students) {}
