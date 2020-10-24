package com.spring.pro29.exo1;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello rest!";
	}
	
	@RequestMapping("/member")
	public MemberVO member()
	{
		MemberVO vo = new MemberVO();
		vo.setId("wldbs");
		vo.setPwd("1234");
		vo.setName("ÁöÀ±");
		vo.setEmail("wldbs@naver.com");
		return vo;
	}
	
	@RequestMapping("/membersList")
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i=0;i<10;i++)
		{
			MemberVO vo = new MemberVO();
			vo.setId("wldbs"+i);
			vo.setPwd("1234"+i);
			vo.setName("ÁöÀ±"+i);
			vo.setEmail("wldbs"+i+"@naver.com");
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping(value="/notice/{num}",method=RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception
	{
		return num;
	}
	
	@RequestMapping(value="/info",method = RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo)
	{
		logger.info(vo.toString());
	}
}
