package com.kodzilar.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "history")
public class History{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id", nullable = false)
    private int historyId;

    @Column(name="patient_id")
    private int patientId;

    @Transient
    private String patientName;

    @Column(name="mission_id")
    private int missionId;

    @Column(name="question_id")
    private int questionId;

    @Column(name="answer")
    private String answer;

    @Column(name="result")
    private String result;

    @Column(name="last_mnt_dt_tm", insertable=false)
    private Date lastMntDate;

    @Column(name="checkin")
    private String checkIn;

    @Column(name="avg_speed_walk")
    private BigDecimal avgSpeedWalk;


    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getLastMntDate() {
        return lastMntDate;
    }

    public void setLastMntDate(Date lastMntDate) {
        this.lastMntDate = lastMntDate;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public BigDecimal getAvgSpeedWalk() {
        return avgSpeedWalk;
    }

    public void setAvgSpeedWalk(BigDecimal avgSpeedWalk) {
        this.avgSpeedWalk = avgSpeedWalk;
    }
}
