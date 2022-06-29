package com.example.ej2crud.infraestructure.dto.output;

import lombok.Data;

@Data
public class OutputStudentSimpleDto {
    private int student_id;
    private String name;
    private int num_hours_week;
    private String comments;
    private String branch;
}
