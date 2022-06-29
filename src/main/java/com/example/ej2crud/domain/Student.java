package com.example.ej2crud.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false, unique = true)
    private int student_id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "name")
    private String name;

    @Column(name = "num_hours_week")
    private int num_hours_week;

    @Column(name = "comments")
    private String comments;

/*
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    private int professor_id;
*/

    @Column(name = "branch")
    private String branch;
}
