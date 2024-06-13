package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "exam details")
public class ExamDetails {
    @EmbeddedId
    private ExamDetailsId id;

    @MapsId("examId")
    @ManyToOne
    @JoinColumn(name = "examID", nullable = false)
    private Exam exam;

    @MapsId("questionId")
    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    @Column(name = "order", nullable = false)
    private Integer order;

    // Getters and setters
}
