package com.example.ej2crud.application;

import com.example.ej2crud.domain.Professor;
import com.example.ej2crud.infraestructure.dto.output.OutputProfessorDto;
import com.example.ej2crud.infraestructure.repository.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListProfessorUseCase {
    @Autowired
    ModelMapper modelMapper;
    public ProfessorRepository professorRepository;
    ListProfessorUseCase(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    private List<OutputProfessorDto> serialize(List<Professor> professorList){
        List<OutputProfessorDto> outputList = new ArrayList<OutputProfessorDto>();
        professorList.forEach(professor -> {
            outputList.add(this.modelMapper.map(professor, OutputProfessorDto.class));
        });
        return outputList;
    }

    public List<OutputProfessorDto> list() {
        List<Professor> professorList = this.professorRepository.findAll();
        return this.serialize(professorList);
    }

}
