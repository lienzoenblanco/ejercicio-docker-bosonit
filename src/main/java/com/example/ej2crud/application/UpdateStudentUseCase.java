package com.example.ej2crud.application;

import com.example.ej2crud.domain.Student;
import com.example.ej2crud.infraestructure.dto.input.InputStudentDto;
import com.example.ej2crud.infraestructure.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateStudentUseCase {
    public StudentRepository studentRepository;
    UpdateStudentUseCase(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Boolean update(InputStudentDto inputStudentDto, int id){
        List<Student> studentList = this.studentRepository.findById(id);
        Student student = studentList.get(0);
        student.setName(inputStudentDto.getName());
        student.setNum_hours_week(inputStudentDto.getNum_hours_week());
        student.setComments(inputStudentDto.getComments());
        student.setBranch(inputStudentDto.getBranch());
        this.studentRepository.save(student);
        return true;
    }
}
