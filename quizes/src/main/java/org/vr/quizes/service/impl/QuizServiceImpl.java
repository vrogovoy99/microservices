package org.vr.quizes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vr.quizes.feign.QuizInterface;
import org.vr.quizes.model.QuestionResponse;
import org.vr.quizes.model.QuestionWrapper;
import org.vr.quizes.model.Quiz;
import org.vr.quizes.model.QuizDTO;
import org.vr.quizes.repository.QuizRepository;
import org.vr.quizes.service.QuizService;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final QuizInterface quizInterface;

    public QuizServiceImpl(QuizRepository quizRepository, QuizInterface quizInterface) {
        this.quizRepository = quizRepository;
        this.quizInterface = quizInterface;
    }

    @Override
    public String createQuiz(QuizDTO quizDTO) {
//        ResponseEntity<List<Long>> qustionsResponce= quizInterface.getListOfQuestions(quizDTO.getCategory(), quizDTO.getNumQuestions());
//        List<Long> questions = qustionsResponce.getBody();

        List<Long> questions= quizInterface.getListOfQuestions(quizDTO.getCategory(), quizDTO.getNumQuestions()).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDTO.getTitle());
        quiz.setQuestionIds(questions);
        quizRepository.save(quiz);

        return "quiz created.";
    }

    @Override
    public List<QuestionWrapper> getQuizQuestions(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Long> questionIdArray = quiz.getQuestionIds();
        return quizInterface.getQuestionFromList(questionIdArray).getBody();
//        return quizInterface.getQuestionFromList(quizRepository.getQuestionsByQuizManual(id)).getBody();
    }

    @Override
    public Long calculateResults(Long id, List<QuestionResponse> responses) {
        return quizInterface.gradeQuestions(responses).getBody();
    }
}
