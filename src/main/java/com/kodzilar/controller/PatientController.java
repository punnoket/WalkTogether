package com.kodzilar.controller;

import com.kodzilar.entity.AssessmentQuestion;
import com.kodzilar.entity.Patient;
import com.kodzilar.entity.Question;
import com.kodzilar.service.AssessmentService;
import com.kodzilar.service.EmailService;
import com.kodzilar.service.UserService;
import com.kodzilar.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private UserService userService;

    @Autowired
    private AssessmentService assessmentService;
  
    @Autowired
    private QuestionService questionService;

    @Autowired
    private EmailService EmailService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus login(@RequestBody Patient patient) {
        return userService.loginPatient(patient);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus register(@RequestBody Patient patient) {
        HttpStatus resultStatus = userService.registerPatient(patient);
        Patient patientId_param = userService.getPatientByUsername(patient);
        System.out.println("resultStatus:" + resultStatus);
        if( HttpStatus.OK == resultStatus ){
            EmailService.sentEmailToNotifyCaretaker(patient.getEmail(), Integer.toString(patientId_param.getPatientId()));
        }
        return resultStatus;
    }

    @RequestMapping(value = "/assessment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AssessmentQuestion> getAssessmentQuestion() {
        return assessmentService.getQuestion();
    }

    //เพิ่ม
    @RequestMapping(value = "/question", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Question> getDesQuestion() {
        return questionService.getQuestion2();
    }

    @RequestMapping(value = "/patientIdForShared", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getPatientIdForShared(@RequestBody Patient patient) {
        return userService.getPatientIdForShared(patient);
    }
}
