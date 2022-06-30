package com.example.ej2crud.infraestructure.repository;

import com.example.ej2crud.domain.Professor;
import com.example.ej2crud.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    List<Professor> findByName(String name);
    List<Professor> findById(int id);
    List<Professor> deleteById(int id);
}
