package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject subject;

    @Column(name = "Quantity", nullable = false, length = 50)
    private String quantity;

    @Column(name = "Time", nullable = false)
    private Time time;

    @Column(name = "Point", nullable = false)
    private Integer point;

    @ManyToOne
    @JoinColumn(name = "StatusID", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    // Getters and setters
}
