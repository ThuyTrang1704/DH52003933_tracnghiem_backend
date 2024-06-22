package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subject")
public class    Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubjectID")
    private Integer id;

    @Column(name = "SubjectName", nullable = false, length = 50)
    private String subjectName;

    // Getters and setters
}
