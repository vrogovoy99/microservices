package org.vr.questions.service;

import org.vr.questions.entity.Question;
import org.vr.questions.entity.QuestionResponse;
import org.vr.questions.entity.QuestionWrapper;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionWrapper> findAll();

    QuestionWrapper findById(Long id);

    QuestionWrapper save(Question question);

    Boolean delete(Long id);

    List<Long> getListOfQuestions(String subject, Integer count);

    Long gradeQuestions(List<QuestionResponse> responses);

    List<QuestionWrapper> getQuestionFromList(List<Long> questionIds);
}
