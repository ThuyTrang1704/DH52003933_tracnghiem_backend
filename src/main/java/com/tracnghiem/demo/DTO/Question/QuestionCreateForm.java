package com.tracnghiem.demo.DTO.Question;

import lombok.Data;
import java.util.List;

@Data
public class QuestionCreateForm {
    private String nameQuestion;
    private Integer difficultyLevel;
    private Integer checkPoint;
    private Integer chapterId;
    private Integer subjectId;
    private Long userId;
//    private List<AnswerCreateForm> answers;
    private Integer correctAnswerId;
}

//@Data
//public class AnswerCreateForm {
//    private String answerText;
//}

