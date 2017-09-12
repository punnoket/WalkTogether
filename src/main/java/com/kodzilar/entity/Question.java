package com.kodzilar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id", nullable = false)
    private int questionId;

    @Column(name = "mission_id")
    private int missionId;

    @Column(name = "question_des")
    private String questionDesc;

    @Column(name = "answer")
    private String answer;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public int getMissionId() {
        return this.missionId;
    }

    public void setQusetions(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getQuestions() {
        return this.questionDesc;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }
}