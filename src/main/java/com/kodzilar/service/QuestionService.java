package com.kodzilar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.kodzilar.entity.AssessmentQuestion;
import com.kodzilar.entity.AssessmentScore;
import com.kodzilar.entity.Patient;
import com.kodzilar.entity.Question;
import com.kodzilar.repository.AssessmentQuestionRepository;
import com.kodzilar.repository.AssessmentScoreRepository;
import com.kodzilar.repository.PatientRepository;
import com.kodzilar.repository.TestQuestionRepository;


@Service
public class QuestionService{

    // @Autowired
    // private AssessmentScoreRepository assessmentScoreRepository;

    // @Autowired
    // private PatientRepository patientRepository;

    @Autowired
    private TestQuestionRepository testquestionRepository;

    public List<Question> getQuestion2(){
        Iterable<Question> aquestionList = testquestionRepository.findAll();
        List<Question> QuestionList = Lists.newArrayList(aquestionList);
        return QuestionList;
    }
}