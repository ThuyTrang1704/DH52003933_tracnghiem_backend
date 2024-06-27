package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Question;

import java.util.List;

public interface IQuestionService {

    List<Question> getAllQuestions();

    Question getQuestionById(Long id);

    Question saveQuestion(Question question);

    Question updateQuestion(Long id, Question updatedQuestion);

    void deleteQuestion(Long id);
}
