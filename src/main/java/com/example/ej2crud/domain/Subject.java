package com.example.ej2crud.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "subject_id", nullable = false, unique = true)
    private int subject_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
