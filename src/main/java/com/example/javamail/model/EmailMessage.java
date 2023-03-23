package com.example.javamail.model;

public class EmailMessage {
    private String fromEmail;
    private String toEmail;
    private String emailSubject;
    private String emailMessage;
    private String emailAttachmentPath;

    public EmailMessage(){}

    public EmailMessage(String fromEmail, String toEmail, String emailSubject, String emailMessage){
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.emailSubject = emailSubject;
        this.emailMessage = emailMessage;
    }

    public EmailMessage(String fromEmail, String toEmail, String emailSubject, String emailMessage, String emailAttachmentPath) {
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.emailSubject = emailSubject;
        this.emailMessage = emailMessage;
        this.emailAttachmentPath = emailAttachmentPath;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getEmailAttachmentPath() {
        return emailAttachmentPath;
    }

    public void setEmailAttachmentPath(String emailAttachmentPath) {
        this.emailAttachmentPath = emailAttachmentPath;
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "fromEmail='" + fromEmail + '\'' +
                ", toEmail='" + toEmail + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", emailMessage='" + emailMessage + '\'' +
                ", emailAttachmentPath='" + emailAttachmentPath + '\'' +
                '}';
    }
}
