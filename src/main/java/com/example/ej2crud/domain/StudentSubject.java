package com.example.ej2crud.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_subject")
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_subject_id", nullable = false, unique = true)
    private int student_subject_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "comments")
    private String comments;

    @Column(name = "initial_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date initial_date;

    @Column(name = "finish_date")
    @Temporal(TemporalType.DATE)
    private Date finish_date;
}
