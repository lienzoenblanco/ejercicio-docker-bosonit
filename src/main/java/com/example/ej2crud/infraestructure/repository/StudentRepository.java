package com.example.ej2crud.infraestructure.repository;

import com.example.ej2crud.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findById(int id);
    List<Student> deleteById(int id);
}
