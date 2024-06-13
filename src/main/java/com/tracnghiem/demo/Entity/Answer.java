package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AnswerID")
    private Integer id;

    @Column(name = "AnswerText", nullable = false)
    private String answerText;

    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    // Getters and setters
}