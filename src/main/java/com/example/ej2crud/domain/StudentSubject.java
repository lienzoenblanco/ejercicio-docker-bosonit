package com.example.ej2crud.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_subject")
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false, unique = true)
    private int subject_id;

    @Column(name = "student_id")
    private int student_id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "comments")
    private String comments;

    @Column(name = "initial_date", nullable = false)
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;
}
