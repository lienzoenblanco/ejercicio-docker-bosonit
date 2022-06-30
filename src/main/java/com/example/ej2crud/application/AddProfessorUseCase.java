package com.example.ej2crud.application;

import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.domain.Professor;
import com.example.ej2crud.infraestructure.dto.input.InputProfessorDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import com.example.ej2crud.infraestructure.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class AddProfessorUseCase {

    public ProfessorRepository professorRepository;
    public PersonRepository personRepository;

    AddProfessorUseCase(ProfessorRepository professorRepository, PersonRepository personRepository){
        this.professorRepository= professorRepository;
        this.personRepository = personRepository;
    }

    public ResponseDto add(InputProfessorDto inputProfessorDto){
        Professor professor = new Professor();
        professor.setPerson(this.personRepository.getById(inputProfessorDto.getPerson_id()));
        professor.setName(inputProfessorDto.getName());
        professor.setComments(inputProfessorDto.getComments());
        professor.setBranch(inputProfessorDto.getBranch());
        this.professorRepository.saveAndFlush(professor);
        return new ResponseDto(true, "El profesor ha sido creado");
    }
}
