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
        private Long id;

        @Column(nullable = false)
        private String content;

//        @ManyToOne
//        @JoinColumn(name = "correct_option_id")
//        private Option correctOption;

        @Column(nullable = false)
        private Integer point;

        @ManyToOne
        @JoinColumn(name = "subject_id")
        private Subject subject;

}

