package com.example.ej2crud.application;

import com.example.ej2crud.domain.Professor;
import com.example.ej2crud.infraestructure.dto.input.InputProfessorDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import com.example.ej2crud.infraestructure.repository.ProfessorRepository;
import lombok.AccessLevel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateProfessorUseCase {

    @Autowired
    ModelMapper modelMapper;
    public ProfessorRepository professorRepository;
    public PersonRepository personRepository;

    UpdateProfessorUseCase(ProfessorRepository professorRepository, PersonRepository personRepository){
        this.professorRepository = professorRepository;
        this.personRepository = personRepository;

    }

    public boolean update(InputProfessorDto inputProfessorDto, int id){
        modelMapper.getConfiguration().setPreferNestedProperties(false).setFieldMatchingEnabled(true);
        Professor professor = professorRepository.findById(id).get(0);
        modelMapper.map(inputProfessorDto, professor);
        professor.setPerson(this.personRepository.getById(inputProfessorDto.getPerson_id()));
        professorRepository.saveAndFlush(professor);
        return true;
    }

}
