package org.vr.quizes.service;

import org.vr.quizes.model.QuestionResponse;
import org.vr.quizes.model.QuestionWrapper;
import org.vr.quizes.model.QuizDTO;

import java.util.List;

public interface QuizService {
    String createQuiz(QuizDTO quizDTO);

    List<QuestionWrapper> getQuizQuestions(Long id);

    Long calculateResults(Long id, List<QuestionResponse> responses);
}
