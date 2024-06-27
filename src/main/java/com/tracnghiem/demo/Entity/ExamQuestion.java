package com.tracnghiem.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "ExamQuestions")
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}