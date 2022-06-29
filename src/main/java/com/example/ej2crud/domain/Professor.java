package com.example.ej2crud.domain;

import javax.persistence.*;

@Entity
@Table
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id", nullable = false, unique = true)
    private int professor_id;

    @Column(name = "person_id")
    private int person_id;

    @Column(name = "comments")
    private String comments;

    @Column(name = "branch")
    private String branch;
}
