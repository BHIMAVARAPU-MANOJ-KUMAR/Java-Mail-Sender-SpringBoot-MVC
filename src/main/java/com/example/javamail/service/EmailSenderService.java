package com.example.javamail.service;

import com.example.javamail.repository.EmailSenderRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderService implements EmailSenderRepository {

    private final JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String emailFrom , String toEmail, String emailSubject, String emailMessage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("manojbh1999@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(emailSubject);
        simpleMailMessage.setText(emailMessage);
        javaMailSender.send(simpleMailMessage);
        System.out.println("An Email has Sent Successfully.");
    }

    @Override
    public void sendEmailwithAttachment(String fromEmail, String toEmail, String emailSubject, String emailMessage, String attachment) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("manojbh1999@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(emailSubject);
        mimeMessageHelper.setText(emailMessage);
        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(mimeMessage);
        System.out.println("An Email Attachment has Sent Successfully.");
    }
}
