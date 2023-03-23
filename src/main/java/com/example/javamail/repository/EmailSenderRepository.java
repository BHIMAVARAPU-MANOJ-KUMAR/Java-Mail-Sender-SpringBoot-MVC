package com.example.javamail.repository;

import jakarta.mail.MessagingException;

public interface EmailSenderRepository {
    public void sendEmail(String fromEmail, String toEmail , String emailSubject , String emailMessage);
    public void sendEmailwithAttachment(String fromEmail , String toEmail , String emailSubject , String emailMessage , String attachment) throws MessagingException;
}
