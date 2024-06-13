package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "groupsubject")
public class GroupSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupSubjectID")
    private Integer id;

    @Column(name = "SubjectName", nullable = false, length = 255)
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "classID", nullable = false)
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "subjectId", nullable = false)
    private Subject subject;

    // Getters and setters
}
