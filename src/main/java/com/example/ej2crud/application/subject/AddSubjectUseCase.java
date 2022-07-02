package com.example.ej2crud.application.subject;

import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.domain.Subject;
import com.example.ej2crud.infraestructure.dto.input.InputSubjectDto;
import com.example.ej2crud.infraestructure.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class AddSubjectUseCase {
    public SubjectRepository subjectRepository;

    AddSubjectUseCase(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public ResponseDto add(InputSubjectDto inputSubjectDto){
        Subject subject = new Subject();
        subject.setName(inputSubjectDto.getName());
        subject.setDescription(inputSubjectDto.getDescription());
        this.subjectRepository.saveAndFlush(subject);
        return new ResponseDto(true, "La asignatura ha sido creada");
    }
}
