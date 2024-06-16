package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.Answer;
import com.tracnghiem.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return questionService.addAnswer(answer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Integer id, @RequestBody Answer answerDetails) {
        return ResponseEntity.ok(questionService.updateAnswer(id, answerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Integer id) {
        questionService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
