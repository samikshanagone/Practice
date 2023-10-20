package com.notofication.NotificationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String toEmail,String userid,String opt) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("genuineloanapp@gmail.com");
		message.setTo(toEmail);
		message.setText("Dear Customer ,\n\n" + "your username is :"+userid+" and your Login OPT is : " + opt + " \n\nRegards,\nSamiksha.");
		message.setSubject("Login Credentials");
		javaMailSender.send(message);
		System.out.println("mail sent for otp....");

	}

	

	public void sendWelcomeMail(String toEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("genuineloanapp@gmail.com");
		message.setTo(toEmail);
		message.setText("Dear Customer ,\n\nIt is with immense pleasure that I welcome you to [company/place]. \nWe are very excited [show the genuine excitement for welcoming the person]. We were very happy [state the reasons for welcoming the person].  \n\nRegards,\nSamiksha.");
		message.setSubject("Welcome To The Service");
		javaMailSender.send(message);
		System.out.println("mail sent for welcome....");
	}
}
