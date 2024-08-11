package org.vr.quizes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vr.quizes.model.QuizDTO;
import org.vr.quizes.model.QuestionResponse;
import org.vr.quizes.model.QuestionWrapper;
import org.vr.quizes.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quiz")

public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO ){
        return ResponseEntity.ok(quizService.createQuiz(quizDTO));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQustions(@PathVariable Long id){
        return ResponseEntity.ok(quizService.getQuizQuestions(id));
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Long> submitQuiz(@PathVariable Long id, @RequestBody List<QuestionResponse> responses){
        return ResponseEntity.ok(quizService.calculateResults(id, responses));
    }
}
