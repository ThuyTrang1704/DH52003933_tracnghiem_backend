package com.tracnghiem.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private Integer id;

    @Column(name = "NameQuestion", nullable = false)
    private String nameQuestion;

    @Column(name = "DifficultyLevel", nullable = false)
    private Integer difficultyLevel;

    @Column(name = "CheckPoint", nullable = false)
    private Integer checkPoint;

    @ManyToOne
    @JoinColumn(name = "ChapterID", nullable = false)
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "AnswerID")
    private Answer correctAnswer;
}