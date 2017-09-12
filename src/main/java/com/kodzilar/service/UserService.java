package com.kodzilar.service;

import java.util.List;
import java.util.ArrayList;

import com.kodzilar.entity.Caretaker;
import com.kodzilar.entity.Patient;
import com.kodzilar.repository.CaretakerRepository;
import com.kodzilar.repository.PatientRepository;
import com.kodzilar.utils.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private CaretakerRepository caretakerRepository;

    @Autowired
    private PatientRepository patientRepository;

    public HttpStatus loginCaretaker(Caretaker caretaker) {

        try {
            String email = caretaker.getEmail();
            String password = StringUtils.getEncodeSHA512(caretaker.getPassword());

            Caretaker caretakerFromDB = caretakerRepository.findByEmail(email);
            if (null != caretakerFromDB
                    && email.equalsIgnoreCase(caretakerFromDB.getEmail())
                    && password.equalsIgnoreCase(caretakerFromDB.getPassword())) {

                return HttpStatus.OK;
            } else {
                return HttpStatus.UNAUTHORIZED;
            }
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus loginPatient(Patient patient) {

        try {
            String username = patient.getUsername();
            String password = StringUtils.getEncodeSHA512(patient.getPassword());

            Patient patientFromDB = patientRepository.findByUsername(username);
            if (null != patientFromDB
                    && username.equalsIgnoreCase(patientFromDB.getUsername())
                    && password.equalsIgnoreCase(patientFromDB.getPassword())) {

                return HttpStatus.OK;
            } else {
                return HttpStatus.UNAUTHORIZED;
            }
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus registerCaretaker(Caretaker caretaker) {
        String email = caretaker.getEmail();
        String password = caretaker.getPassword();
        String patientCare;
        Caretaker caretakerOld = new Caretaker();
        try {
            if (null == caretakerRepository.findByEmail(email)) {
                caretaker.setPassword(StringUtils.getEncodeSHA512(password));
                caretakerRepository.save(caretaker);
            } else if(null != caretakerRepository.findByEmail(email)) {
                caretakerOld = caretakerRepository.findByEmail(email);
                caretaker.setCartakerId(caretakerOld.getCartakerId());
                caretaker.setPassword(StringUtils.getEncodeSHA512(password));
                caretakerRepository.save(caretaker);
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

    public HttpStatus registerPatient(Patient patient) {
        String username = patient.getUsername();
        String password = patient.getPassword();
        Caretaker caretaker = new Caretaker();
        try {
            if (null == patientRepository.findByUsername(username)) {
                if (null == caretakerRepository.findByEmail(patient.getEmail())) {
                    caretaker.setEmail(patient.getEmail());
                    caretakerRepository.save(caretaker);
                } else {
                    caretaker = caretakerRepository.findByEmail(patient.getEmail());
                }
                
                patient.setCaretakerId(caretaker.getCartakerId());
                patient.setPassword(StringUtils.getEncodeSHA512(password));
                patientRepository.save(patient);
                
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }
    
    public Patient getPatientByUsername(Patient patient) {
        return patientRepository.findByUsername(patient.getUsername());
    }

    public String getPatientIdForShared(Patient patient) {
        return patientRepository.findPatientIdByUsername(patient.getUsername());
    }

}
