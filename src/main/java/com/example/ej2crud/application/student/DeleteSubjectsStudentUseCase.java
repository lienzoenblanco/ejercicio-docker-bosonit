package com.example.ej2crud.application.student;

import com.example.ej2crud.domain.Student;
import com.example.ej2crud.domain.Subject;
import com.example.ej2crud.infraestructure.dto.output.OutputSubjectDto;
import com.example.ej2crud.infraestructure.repository.StudentRepository;
import com.example.ej2crud.infraestructure.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteSubjectsStudentUseCase {

    @Autowired
    ModelMapper modelMapper;
    public StudentRepository studentRepository;
    public SubjectRepository subjectRepository;
    DeleteSubjectsStudentUseCase(
            StudentRepository studentRepository, SubjectRepository subjectRepository
    ){
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<OutputSubjectDto> deleteList(int student_id, List<String> idSubjects) {

        Student student = studentRepository.findById(student_id).get(0);
        List<Subject> subjectList = new ArrayList<>();

        idSubjects.forEach(subject_id -> {
            Subject subject = subjectRepository.findById(Integer.parseInt(subject_id)).get(0);
            subjectList.add(subject);

        });

        subjectList.forEach(subject -> {
            if (student.getSubjectList().contains(subject)) {
                student.getSubjectList().remove(subject);
                studentRepository.save(student);
            }
        });

        List<OutputSubjectDto> subjectListOutputDTO = new ArrayList<>();
        subjectList.forEach(subject -> {
            OutputSubjectDto subjectOutputDTO = modelMapper.map(subject, OutputSubjectDto.class );
            subjectListOutputDTO.add(subjectOutputDTO);
        });

        return subjectListOutputDTO;
    }
}
