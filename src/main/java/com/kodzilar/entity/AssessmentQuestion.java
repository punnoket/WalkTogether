package com.kodzilar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_question")
public class AssessmentQuestion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assessment_id", nullable = false)
    private int assessmentId;
    
    @Column(name="question")
    private String question;

    @Column(name="result")
    private String result;

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }
}