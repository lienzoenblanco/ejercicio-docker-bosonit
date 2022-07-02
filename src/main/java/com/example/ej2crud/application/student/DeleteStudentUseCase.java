package com.example.ej2crud.application.student;

import com.example.ej2crud.infraestructure.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase {
    public StudentRepository studentRepository;
    DeleteStudentUseCase(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void delete(int id) {
        this.studentRepository.deleteById(id);
    }
}
