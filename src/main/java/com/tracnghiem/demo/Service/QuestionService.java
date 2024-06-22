package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Question;
import com.tracnghiem.demo.Entity.Answer;
import com.tracnghiem.demo.Repository.QuestionRepository;
import com.tracnghiem.demo.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Integer id, Question questionDetails) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found for this id :: " + id));

        question.setNameQuestion(questionDetails.getNameQuestion());
        question.setCheckPoint(questionDetails.getCheckPoint());
        question.setChapter(questionDetails.getChapter());
        question.setSubject(questionDetails.getSubject());
        question.setUser(questionDetails.getUser());
        question.setCorrectAnswer(questionDetails.getCorrectAnswer());

        return questionRepository.save(question);
    }

    public void deleteQuestion(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found for this id :: " + id));
        questionRepository.delete(question);
    }

    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Integer id, Answer answerDetails) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found for this id :: " + id));

        answer.setAnswerText(answerDetails.getAnswerText());
        return answerRepository.save(answer);
    }

    public void deleteAnswer(Integer id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found for this id :: " + id));
        answerRepository.delete(answer);
    }
}
