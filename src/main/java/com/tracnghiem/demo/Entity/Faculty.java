package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "facultty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FacultyID")
    private Integer id;

    @Column(name = "FacultyName", nullable = false, length = 50)
    private String facultyName;

    // Getters and setters
}
