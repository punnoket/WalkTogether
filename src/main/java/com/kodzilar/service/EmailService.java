package com.kodzilar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kodzilar.mail.MailClient;

@Service
public class EmailService{

    @Autowired
    @Qualifier("mailClient")
    private MailClient mailClient;

    public void sentEmailToNotifyCaretaker(String recipient, String patientId){
        mailClient.prepareEmail(recipient, patientId);
        mailClient.send();
    }
}