package com.tracnghiem.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChapterID")
    private Integer id;

    @Column(name = "NameChapter", nullable = false, length = 50)
    private String nameChapter;

    @Column(name = "Content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "SubjectID", nullable = false)
    private Subject subject;

    // Getters and setters
}

