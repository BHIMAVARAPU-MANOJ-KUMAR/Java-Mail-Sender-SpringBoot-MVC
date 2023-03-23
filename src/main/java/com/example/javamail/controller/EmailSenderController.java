package com.example.javamail.controller;

import com.example.javamail.model.EmailMessage;
import com.example.javamail.repository.EmailSenderRepository;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailSenderController {
    private final EmailSenderRepository emailSenderRepository;

    public EmailSenderController(EmailSenderRepository emailSenderRepository) {
        this.emailSenderRepository = emailSenderRepository;
    }

    @RequestMapping(value = "/send-email" , method = RequestMethod.POST)
    public ResponseEntity<String> emailSending(@RequestBody EmailMessage emailMessage) {
        this.emailSenderRepository.sendEmail(emailMessage.getFromEmail() , emailMessage.getToEmail() , emailMessage.getEmailSubject() , emailMessage.getEmailMessage());
        return new ResponseEntity<>("You Have Sent An Email Successfully TO :- " + emailMessage.getToEmail() , HttpStatus.OK);
    }

    @RequestMapping(value = "/send-email-attachment" , method = RequestMethod.POST)
    public ResponseEntity<String> emailSendAttachment(@RequestBody EmailMessage emailMessage) throws MessagingException {
        this.emailSenderRepository.sendEmailwithAttachment(emailMessage.getFromEmail() , emailMessage.getToEmail() , emailMessage.getEmailSubject() , emailMessage.getEmailMessage() , emailMessage.getEmailAttachmentPath());
        return new ResponseEntity<>("You Have Sent an Email With An Attachment TO :- " + emailMessage.getToEmail(), HttpStatus.OK);
    }
}
