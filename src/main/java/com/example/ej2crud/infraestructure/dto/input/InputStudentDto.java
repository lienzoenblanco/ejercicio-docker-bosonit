package com.example.ej2crud.infraestructure.dto.input;

import lombok.Data;

@Data
public class InputStudentDto {
    private int person_id;
    private String name;
    private int num_hours_week;
    private String comments;
    private String branch;
}
