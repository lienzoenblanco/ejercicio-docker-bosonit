package com.example.ej2crud.application;

import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.domain.Student;
import com.example.ej2crud.infraestructure.dto.input.InputStudentDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import com.example.ej2crud.infraestructure.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AddStudentUseCase {

    public StudentRepository studentRepository;
    public PersonRepository personRepository;

    AddStudentUseCase(StudentRepository studentRepository, PersonRepository personRepository) {
        this.studentRepository = studentRepository;
        this.personRepository = personRepository;
    }

    public ResponseDto add(InputStudentDto inputStudentDto) {
        Student student = new Student();
        student.setPerson(this.personRepository.getById(inputStudentDto.getPerson_id()));
        student.setName(inputStudentDto.getName());
        student.setNum_hours_week(inputStudentDto.getNum_hours_week());
        student.setComments(inputStudentDto.getComments());
        student.setBranch(inputStudentDto.getBranch());
        this.studentRepository.saveAndFlush(student);
        return new ResponseDto(true, "El estudiante ha sido creado");
    }
}
