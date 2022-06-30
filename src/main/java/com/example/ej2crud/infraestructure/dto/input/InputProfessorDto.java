package com.example.ej2crud.infraestructure.dto.input;

import lombok.Data;

@Data
public class InputProfessorDto {
    private int person_id;
    private String name;
    private String comments;
    private String branch;
}
