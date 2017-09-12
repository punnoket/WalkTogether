package com.kodzilar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "patient")
public class Patient implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id", nullable = false)
    int patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String email;

    @Column(name = "caretaker_id")
    private int caretakerId;

    @Column(name = "email")
    private String emailCaretaker;

    @Column(name = "last_mnt_dt_tm", insertable=false)
    private Date lastMntDateTime;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(int caretakerId) {
        this.caretakerId = caretakerId;
    }

    public String getEmailCaretaker() {
        return emailCaretaker;
    }

    public void setEmailCaretaker(String emailCaretaker) {
        this.emailCaretaker = emailCaretaker;
    }

    public Date getLastMntDateTime() {
        return lastMntDateTime;
    }

    public void setLastMntDateTime(Date lastMntDateTime) {
        this.lastMntDateTime = lastMntDateTime;
    }
}
