package com.myspring.pro28.ex03;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/sendMail.do",method=RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		mailService.sendMail("eeww789@naver.com", "Test Mail","Hello, This Mail is Test");
		mailService.sendPreConfiguredMail("test mail");
		out.print("mail send");
	}
}
