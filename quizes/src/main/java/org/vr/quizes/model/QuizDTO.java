package org.vr.quizes.model;

import lombok.Data;

@Data
public class QuizDTO {
    private String category;
    private Integer numQuestions;
    private String title;

}
