package com.tracnghiem.demo.Repository;

import com.tracnghiem.demo.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
