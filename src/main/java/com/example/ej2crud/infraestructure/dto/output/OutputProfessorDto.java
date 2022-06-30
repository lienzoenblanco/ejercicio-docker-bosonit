package com.example.ej2crud.infraestructure.dto.output;

import lombok.Data;

@Data
public class OutputProfessorDto {
    private int professor_id;
    private String name;
    private String comments;
    private String branch;
}
