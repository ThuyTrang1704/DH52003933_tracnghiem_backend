package com.tracnghiem.demo.DTO.Question;

import com.tracnghiem.demo.DTO.Answer.AnswerDTO;

import java.util.List;

public class QuestionDTO {
    private Integer id;
    private String nameQuestion;
    private Integer difficultyLevel;
    private Integer checkPoint;
    private Integer chapterId;
    private Integer subjectId;
    private Integer userId;
    private Integer correctAnswerId;
    private List<AnswerDTO> answers;
}
