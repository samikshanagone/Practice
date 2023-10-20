package com.notofication.NotificationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notofication.NotificationService.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping("/getOpt/{mail}/{userid}/{opt}")
	public String GetOPT(@PathVariable String mail,@PathVariable String userid,@PathVariable String otp) {
		notificationService.sendMail(mail,userid,otp);
		return "sent";
	}

	@PostMapping("/sendWelcomeMail/{mail}")
	public String SendMail(@PathVariable String mail) {
		notificationService.sendWelcomeMail(mail);
		return "";
	}
}
