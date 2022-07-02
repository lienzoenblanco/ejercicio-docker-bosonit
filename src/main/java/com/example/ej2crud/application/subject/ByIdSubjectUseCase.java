package com.example.ej2crud.application.subject;

import com.example.ej2crud.domain.Subject;
import com.example.ej2crud.infraestructure.dto.output.OutputSubjectDto;
import com.example.ej2crud.infraestructure.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ByIdSubjectUseCase {

    @Autowired
    ModelMapper modelMapper;
    public SubjectRepository subjectRepository;

    ByIdSubjectUseCase(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    private OutputSubjectDto serialize(Subject subject) {
        OutputSubjectDto output = this.modelMapper.map(subject, OutputSubjectDto.class);
        return output;
    }

    public OutputSubjectDto getById(int id) {
        List<Subject> subjectList = this.subjectRepository.findById(id);
        return this.serialize(subjectList.get(0));
    }
}
