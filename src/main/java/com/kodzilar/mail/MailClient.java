package com.kodzilar.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component("mailClient")
public class MailClient{

    private JavaMailSender mailSender;
    private MimeMessagePreparator mimeMessage;
    private TemplateEngine templates;

    private static final String TEMPLATE_EMAIL = "inviteTemplate";

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    public MailClient(JavaMailSender mailSender, TemplateEngine templates){
        this.mailSender = mailSender;
        this.templates = templates;
    }

    public void prepareEmail(String recipient, String patientId_param){
        Context ctx = new Context();
        ctx.setVariable("patientId_param", patientId_param);
        mimeMessage = (mimeMessage)-> {
            String message = buildTemplate(ctx);

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(fromEmail);
            messageHelper.setTo(recipient);
            messageHelper.setSubject("This is the good chance to help the people.");
            messageHelper.setText(message, true);
        };
    }

    private String buildTemplate(Context ctx){
        return templates.process(TEMPLATE_EMAIL, ctx);
    }

    public void send(){
        mailSender.send(mimeMessage);
    }
}