package com.femcoders.my_university.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequestDTO(
    @NotBlank(message = "Nombre es requerido")
    @Size(min = 2, max = 50, message = "Nombre debe contener entre 2 y 50 caracteres")
    String name, 
    @NotBlank(message = "Apellido es requerido")
    String lastname, 
    @NotBlank(message = "Identificación es requerida")
    String dni_nie) {
}
