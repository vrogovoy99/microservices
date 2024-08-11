package org.vr.questions.controller;


import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vr.questions.entity.Question;
import org.vr.questions.entity.QuestionResponse;
import org.vr.questions.entity.QuestionWrapper;
import org.vr.questions.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionsService;
    private final Environment environment;

    public QuestionController(QuestionService questionsService, Environment environment) {
        this.questionsService = questionsService;
        this.environment = environment;
    }

//    get list of all questions
    @GetMapping
    public ResponseEntity<List<QuestionWrapper>> findAllQuestions (){
        return ResponseEntity.ok(questionsService.findAll());
        
    }
//    get question by id
    @GetMapping("byId")
    public ResponseEntity<QuestionWrapper> findQustionByID(@RequestParam Long id){

        return ResponseEntity.ok(questionsService.findById(id));
    }
//    add question
    @PostMapping
    public ResponseEntity<QuestionWrapper> addQuestion(@RequestBody Question question){

        return ResponseEntity.ok(questionsService.save(question));
    }
//    delete question
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable Long id){

        return ResponseEntity.ok(questionsService.delete(id));
    }
//    generate list of questions for quiz
    @GetMapping("getList")
    public ResponseEntity<List<Long>> getListOfQuestions (@RequestParam String subject, @RequestParam Integer count){

        return ResponseEntity.ok(questionsService.getListOfQuestions(subject, count));

    }
//    grade question answer
    @PostMapping("gradeQuestions")
    public ResponseEntity<Long> gradeQuestions(@RequestBody List<QuestionResponse> responses){

        System.out.println("------------DEBAG:   " + environment.getProperty("local.server.port"));

        return ResponseEntity.ok(questionsService.gradeQuestions(responses));
    }
    @PostMapping("getQuestionFromList")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromList(@RequestBody List<Long> questionIds){

        return ResponseEntity.ok(questionsService.getQuestionFromList(questionIds));
    }
}
