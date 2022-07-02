package com.example.ej2crud.application.professor;

import com.example.ej2crud.domain.Professor;
import com.example.ej2crud.infraestructure.dto.output.OutputProfessorDto;
import com.example.ej2crud.infraestructure.repository.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ByIdProfessorUseCase {

    @Autowired
    ModelMapper modelMapper;
    public ProfessorRepository professorRepository;

    ByIdProfessorUseCase(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    private OutputProfessorDto serialize(Professor professor) {
        OutputProfessorDto output = this.modelMapper.map(professor, OutputProfessorDto.class);
        return output;
    }

    public OutputProfessorDto getById(int id) {
        List<Professor> professorList = this.professorRepository.findById(id);
        return this.serialize(professorList.get(0));
    }
}
