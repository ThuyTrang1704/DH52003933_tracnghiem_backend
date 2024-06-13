package com.tracnghiem.demo.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ExamDetailsId implements Serializable {
    private Integer examId;
    private Integer questionId;

    // Getters, setters, equals, and hashCode
}
