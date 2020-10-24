package com.spring.pro29.exo2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResController {
	@RequestMapping(value="/res1")
	@ResponseBody
	public Map<String,Object> res1()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", "wldbs");
		map.put("name","ÁöÀ±");
		return map;
	}
	
	@RequestMapping(value="/res2")
	public ModelAndView res()
	{
		return new ModelAndView("home");
	}
}
