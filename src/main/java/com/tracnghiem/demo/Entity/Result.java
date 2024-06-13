package com.tracnghiem.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "examID", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "correct quantity", nullable = false)
    private Integer correctQuantity;

    // Getters and setters
}

