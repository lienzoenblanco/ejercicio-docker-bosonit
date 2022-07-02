package com.example.ej2crud.application.student;

import com.example.ej2crud.domain.Student;
import com.example.ej2crud.infraestructure.dto.output.OutputStudentFullDto;
import com.example.ej2crud.infraestructure.dto.output.OutputStudentSimpleDto;
import com.example.ej2crud.infraestructure.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListStudentUseCase {
    public StudentRepository studentRepository;
    ListStudentUseCase(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    
    private List<OutputStudentSimpleDto> serialize(List<Student> studentList) {
        ArrayList<OutputStudentSimpleDto> outputList = new ArrayList<OutputStudentSimpleDto>();
        for (Student student : studentList) {
            OutputStudentSimpleDto output = new OutputStudentSimpleDto();
            output.setStudent_id(student.getStudent_id());
            output.setName(student.getName());
            output.setNum_hours_week(student.getNum_hours_week());
            output.setComments(student.getComments());
            output.setBranch(student.getBranch());
            outputList.add(output);
        }
        return outputList;
    }

    public List<OutputStudentSimpleDto> list() {
        List<Student> studentList = this.studentRepository.findAll();
        return this.serialize(studentList);
    }

}
