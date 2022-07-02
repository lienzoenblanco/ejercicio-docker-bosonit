package com.example.ej2crud.infraestructure.repository;

import com.example.ej2crud.domain.Student;
import com.example.ej2crud.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findById(int id);
    List<Subject> deleteById(int id);


}
