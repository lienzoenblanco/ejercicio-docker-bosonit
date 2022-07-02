package com.example.ej2crud.application.subject;

import com.example.ej2crud.domain.Subject;
import com.example.ej2crud.infraestructure.dto.input.InputSubjectDto;
import com.example.ej2crud.infraestructure.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSubjectUseCase {
    @Autowired
    ModelMapper modelMapper;

    public SubjectRepository subjectRepository;

    UpdateSubjectUseCase(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public boolean update(InputSubjectDto inputSubjectDto, int id){
        Subject subject = subjectRepository.findById(id).get(0);
        modelMapper.map(inputSubjectDto, subject);
        subjectRepository.saveAndFlush(subject);
        return true;
    }
}
