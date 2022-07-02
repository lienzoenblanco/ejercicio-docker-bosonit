package com.example.ej2crud.application.subject;

import com.example.ej2crud.application.professor.DeleteProfessorUseCase;
import com.example.ej2crud.infraestructure.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteSubjectUseCase {
    public
    SubjectRepository subjectRepository;

    DeleteSubjectUseCase(SubjectRepository subjectRepository){
        this.subjectRepository =subjectRepository;
    }

    public void delete(int id){
        this.subjectRepository.deleteById(id);
    }
}
