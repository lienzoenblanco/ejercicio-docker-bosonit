package com.example.ej2crud.application;

import com.example.ej2crud.infraestructure.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfessorUseCase {
    public ProfessorRepository professorRepository;

    DeleteProfessorUseCase(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public void delete(int id){
        this.professorRepository.deleteById(id);
    }
}
