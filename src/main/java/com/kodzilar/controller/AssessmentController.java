package com.kodzilar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodzilar.entity.AssessmentScore;
import com.kodzilar.service.AssessmentService;

@Controller
@RequestMapping("/api/assessment")
public class AssessmentController{

    @Autowired 
    private AssessmentService assessmentService;

    @RequestMapping(value="/save", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void saveAssesment(@RequestBody AssessmentScore assessmentScore){
        assessmentService.seveAssessment(assessmentScore);
    }
}