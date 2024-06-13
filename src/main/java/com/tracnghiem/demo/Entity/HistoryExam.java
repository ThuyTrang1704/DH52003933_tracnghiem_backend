package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "history_exam")
public class HistoryExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyID")
    private Integer id;

    @Column(name = "historyName", nullable = false, length = 250)
    private String historyName;

    @ManyToOne
    @JoinColumn(name = "StatusID", nullable = false)
    private Status status;

    // Getters and setters
}
