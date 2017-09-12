package com.kodzilar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="assessment_score")
public class AssessmentScore{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assessment_id", nullable = false)
    private int assessmentId;

    @Column(name="previous_score")
    private int previousScore;

    @Column(name="current_score")
    private int currentScore;

    @Column(name="patient_id")
    private int patientId;

    @Transient
    private String patientName;

    public void setPreviousScore(int previousScore){
        this.previousScore = previousScore;
    }

    public int getPreviousScore(){
        return previousScore;
    }

     public void setCurrentScore(int currentScore){
        this.currentScore = currentScore;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    public void setPatientId(int patientId){
        this.patientId = patientId;
    }

    public int getPatientId(){
        return patientId;
    }

    public void setPatientName(String patientName){
        this.patientName = patientName;
    }

    public String getPatientName(){
        return patientName;
    }
}