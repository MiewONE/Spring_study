package com.myspring.pro28.ex05;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LocaleInterceptor extends HandlerInterceptorAdapter{
	//@RequestParam("imageFileName") String imageFileName
	@Override
	public boolean preHandle( HttpServletRequest req,HttpServletResponse res,Object handler)
	{
		HttpSession session = req.getSession();
		String locale = req.getParameter("locale");
		if(locale == null) locale="ko";
		
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE",new Locale(locale));
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest req,HttpServletResponse res,Object hanlder,ModelAndView mav) throws Exception
	{
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest req,HttpServletResponse res,Object hanlder,Exception ex) throws Exception
	{
		
	}
	
}
