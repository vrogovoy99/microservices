package org.vr.quizes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.vr.quizes.model.QuestionResponse;
import org.vr.quizes.model.QuestionWrapper;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("/question/getList")
     ResponseEntity<List<Long>> getListOfQuestions (@RequestParam String subject, @RequestParam Integer count);

    //    grade question answer
    @PostMapping("/question/gradeQuestions")
    ResponseEntity<Long> gradeQuestions(@RequestBody List<QuestionResponse> responses);

    @PostMapping("/question/getQuestionFromList")
    ResponseEntity<List<QuestionWrapper>> getQuestionFromList(@RequestBody List<Long> questionIds);

}
