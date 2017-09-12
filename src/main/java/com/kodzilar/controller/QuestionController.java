package com.kodzilar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodzilar.entity.Question;
import com.kodzilar.service.QuestionService;

@Controller
@RequestMapping("/api/question")

public class QuestionController{

    @Autowired 
    private QuestionService questionService;
}