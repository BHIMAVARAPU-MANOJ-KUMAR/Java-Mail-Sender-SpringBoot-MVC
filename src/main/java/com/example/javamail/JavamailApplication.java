package com.example.javamail;

import com.example.javamail.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JavamailApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(JavamailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		emailSenderService.sendEmail("manojbh1999@gmail.com" , "cb.en.u4eie17010@cb.students.amrita.edu" , "JavaMailSender Simple Email With Spring." , "Hai. This is an Test Email Using With Spring Boot MVC JavaMailSender.");
		emailSenderService.sendEmailwithAttachment("manojbh1999@gmail.com", "cb.en.u4eie17010@cb.students.amrita.edu" , "JavaMailSender Simple Email With Spring." , "Hai. This is an Test Email Using With Spring Boot MVC JavaMailSender." , "C:\\Users\\Sraddha\\Pictures\\Screenshots\\BingAI.PNG");
	}
}
