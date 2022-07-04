package com.example.ej2crud.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false, unique = true)
    private int student_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "name")
    private String name;

    @Column(name = "num_hours_week")
    private int num_hours_week;

    @Column(name = "comments")
    private String comments;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Column(name = "branch")
    private String branch;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Subject> subjectList = new ArrayList<>();

    public void addSubject (Subject subject) {
        subjectList.add(subject);
    }
}
