package com.tracnghiem.demo.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false)
    private Boolean status; // Trạng thái đáp án đúng

}
