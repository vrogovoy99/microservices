package org.vr.questions.service.impl;

import org.apache.coyote.Response;
import org.springframework.stereotype.Service;
import org.vr.questions.entity.Question;
import org.vr.questions.entity.QuestionResponse;
import org.vr.questions.entity.QuestionWrapper;
import org.vr.questions.repository.QuestionRepository;
import org.vr.questions.service.QuestionService;
import org.vr.questions.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final MapperUtil mapperUtil;

    public QuestionServiceImpl(QuestionRepository questionRepository, MapperUtil mapperUtil) {
        this.questionRepository = questionRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<QuestionWrapper> findAll() {
        return questionRepository.findAll().stream()
                .map(q -> mapperUtil.convert(q, new QuestionWrapper()))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionWrapper findById(Long id) {
        return mapperUtil.convert(questionRepository.findById(id), new QuestionWrapper());

    }

    @Override
    public QuestionWrapper save(Question question) {
        try {
            //make sure it is a new question
            question.setId(null);
            questionRepository.save(question);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return (new QuestionWrapper());
        }
        return mapperUtil.convert(question, new QuestionWrapper());
    }

    @Override
    public Boolean delete(Long id) {
        try {
            questionRepository.deleteById(id);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Long> getListOfQuestions(String subject, Integer count) {
        System.out.println("DEBUG: subject " + subject + ", count " + count);
        return questionRepository.findBySubject(subject, count);
    }

    @Override
    public Long gradeQuestions(List<QuestionResponse> responses) {

        Long i = 0L;
        for(QuestionResponse r: responses){
            if (r.getResponse().equals(questionRepository.getRightResponse(r.getId()))) i++;
        }

        return i;
    }

    @Override
    public List<QuestionWrapper> getQuestionFromList(List<Long> questionIds) {
        String idList = questionIds.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("DEBUG: id list: " + idList);
        return questionRepository.getQuestionFromId(questionIds).stream()
                .map(q -> mapperUtil.convert(q, new QuestionWrapper()))
                .collect(Collectors.toList());
    }
}

