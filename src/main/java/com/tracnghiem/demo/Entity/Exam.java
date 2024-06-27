package com.tracnghiem.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "exam")
public class Exam {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private Integer totalPoints;

        @Column(nullable = false)
        private Integer duration; // Thời gian làm bài tính bằng phút

        @ManyToOne
        @JoinColumn(name = "subject_id")
        private Subject subject;

}
