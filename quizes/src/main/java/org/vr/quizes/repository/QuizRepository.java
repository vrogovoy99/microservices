package org.vr.quizes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vr.quizes.model.QuestionResponse;
import org.vr.quizes.model.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
//    List<Long> getQuestionsByQuiz(Long id);

    @Query(value = "SELECT question_ids FROM quiz_question_ids q WHERE quiz_id=:id", nativeQuery = true)
    List<Long> getQuestionsByQuizManual(Long id);
}
