package com.kodzilar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.kodzilar.entity.AssessmentQuestion;
import com.kodzilar.entity.AssessmentScore;
import com.kodzilar.entity.Patient;
import com.kodzilar.repository.AssessmentQuestionRepository;
import com.kodzilar.repository.AssessmentScoreRepository;
import com.kodzilar.repository.PatientRepository;

@Service
public class AssessmentService{

    @Autowired
    private AssessmentScoreRepository assessmentScoreRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AssessmentQuestionRepository assessmentQuestionRepository;

    public void seveAssessment(AssessmentScore assessmentScore){
        Patient patient = patientRepository.findByUsername(assessmentScore.getPatientName());
        int patientId = patient.getPatientId();

        assessmentScore.setPatientId(patientId);
        AssessmentScore assessment = assessmentScoreRepository.findByPatientId(patient.getPatientId());

        if(null == assessment){
            assessmentScoreRepository.save(assessmentScore);
        } else {
            int previousScore = assessment.getCurrentScore();
            assessment.setCurrentScore(assessmentScore.getCurrentScore());
            assessment.setPreviousScore(previousScore);
            assessmentScoreRepository.save(assessment);
        }
    }

    public List<AssessmentQuestion> getQuestion(){
        Iterable<AssessmentQuestion> questionList = assessmentQuestionRepository.findAll();
        List<AssessmentQuestion> assessmentQuestionList = Lists.newArrayList(questionList);
        return assessmentQuestionList;
    }
}