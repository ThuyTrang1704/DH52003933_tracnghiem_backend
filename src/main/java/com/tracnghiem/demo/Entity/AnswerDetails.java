package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer_details")
public class AnswerDetails {
    @EmbeddedId
    private AnswerDetailsId id;

    @Column(name = "selected_answer", nullable = false)
    private Integer selectedAnswer;

    @MapsId("answerId")
    @ManyToOne
    @JoinColumn(name = "AnswerID", nullable = false)
    private Answer answer;

    @MapsId("questionId")
    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    // Getters and setters
}
