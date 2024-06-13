package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "class")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassID")
    private Integer id;

    @Column(name = "NameClass", nullable = false, length = 50)
    private String nameClass;

    @ManyToOne
    @JoinColumn(name = "FacultyID", nullable = false)
    private Faculty faculty;

    // Getters and setters
}
