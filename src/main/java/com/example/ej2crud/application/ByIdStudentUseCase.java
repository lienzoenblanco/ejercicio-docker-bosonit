package com.example.ej2crud.application;

import com.example.ej2crud.domain.Student;
import com.example.ej2crud.infraestructure.dto.output.OutputStudentFullDto;
import com.example.ej2crud.infraestructure.repository.StudentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ByIdStudentUseCase {
    public StudentRepository studentRepository;
    ByIdStudentUseCase(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    private OutputStudentFullDto serialize(Student student) {
        OutputStudentFullDto output = new OutputStudentFullDto();
        output.setStudent_id(student.getStudent_id());
        output.setNum_hours_week(student.getNum_hours_week());
        output.setComments(student.getComments());
        output.setBranch(student.getBranch());
        output.setPerson_id(student.getPerson().getPerson_id());
        output.setUser(student.getPerson().getUser());
        output.setPassword(student.getPerson().getPassword());
        output.setName(student.getPerson().getName());
        output.setSurname(student.getPerson().getSurname());
        output.setCompany_email(student.getPerson().getCompany_email());
        output.setPersonal_email(student.getPerson().getPersonal_email());
        output.setCity(student.getPerson().getCity());
        output.setActive(student.getPerson().getActive());
        output.setCreated_date(student.getPerson().getCreated_date());
        output.setImage_url(student.getPerson().getImage_url());

        return output;
    }

    public OutputStudentFullDto getById(int id) {
        List<Student> studentList = this.studentRepository.findById(id);
        return this.serialize(studentList.get(0));
    }

}
