package com.myspring.pro28.ex03;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	
	@Async
	public void sendMail(String to,String subject,String body)
	{
		MimeMessage msg = mailSender.createMimeMessage();
		try
		{
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg,true,"UTF-8");
			msgHelper.setCc("eeww789@naver.com");
			msgHelper.setFrom("eeww789@naver.com","¹Ú¿ø±Õ");
			msgHelper.setSubject(subject);
			msgHelper.setReplyTo(to);
			msgHelper.setText(body);
			mailSender.send(msg);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Async
	public void sendPreConfiguredMail(String msg)
	{
		SimpleMailMessage mailMsg = new SimpleMailMessage(preConfiguredMessage);
		mailMsg.setText(msg);
		mailSender.send(mailMsg);
	}
}
