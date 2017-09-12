package com.kodzilar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "caretaker")
public class Caretaker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "caretaker_id", nullable = false)
    int cartakerId;

    // @JoinColumn(foreignKey = @ForeignKey(name = "patient_id"))
    // int patient_id;

    @Column(name = "patient_id")
    private int patient_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "last_mnt_dt_tm")
    private Timestamp lastMntDateTime;

    public int getCartakerId() {
        return cartakerId;
    }

    public void setCartakerId(int cartakerId) {
        this.cartakerId = cartakerId;
    }

    public int getPatientId() {
        return patient_id;
    }

    public void setPatientId(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastMntDateTime() {
        return lastMntDateTime;
    }

    public void setLastMntDateTime(Timestamp lastMntDateTime) {
        this.lastMntDateTime = lastMntDateTime;
    }
}
