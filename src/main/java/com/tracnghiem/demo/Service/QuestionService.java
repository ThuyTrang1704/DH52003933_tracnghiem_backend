package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Question;
import com.tracnghiem.demo.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Integer id, Question questionDetails) {
        return questionRepository.findById(id)
//                .map(question -> {
//                    question.setNameQuestion(questionDetails.getNameQuestion());
//                    question.setDifficultyLevel(questionDetails.getDifficultyLevel());
//                    question.setCheckPoint(questionDetails.getCheckPoint());
//                    question.setChapter(questionDetails.getChapter());
//                    question.setSubject(questionDetails.getSubject());
//                    question.setUser(questionDetails.getUser());
//                    question.setAnswers(questionDetails.getAnswers());
//                    question.setCorrectAnswer(questionDetails.getCorrectAnswer());
//                    return questionRepository.save(question);
//                })
                .orElseThrow(() -> new RuntimeException("Question not found with id " + id));
    }

    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
}
