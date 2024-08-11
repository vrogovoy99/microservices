package org.vr.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vr.questions.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT q.id FROM question q WHERE q.subject=:subject ORDER BY random() LIMIT :count", nativeQuery = true)
    List<Long> findBySubject(String subject, Integer count);

    @Query(value = "SELECT correct_response FROM question q WHERE id=:id", nativeQuery = true)
    String getRightResponse(Long id);

    @Query(value = "SELECT * FROM question q WHERE id in (:string)", nativeQuery = true)
    List<Question> getQuestionFromId(List<Long> string);
}
