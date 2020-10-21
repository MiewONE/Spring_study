package com.spring.ex04;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

//	public List<MemberVO> selectAllMemberList() {
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		List<MemberVO> memlist = null;
//		memlist = session.selectList("mapper.member.selectAllMemberList");
////		memlist = session.
//		return memlist;
//	}
	
	public String selectName()
	{
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String name = session.selectOne("mapper.member.selectName");
		return name;
	}
	public int selectPwd()
	{
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int pwd = session.selectOne("mapper.member.selectPwd");
		return pwd;
	}
	 public List<MemberVO> selectAllMemberList() { 
		sqlMapper = getInstance(); 
     	SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null; 
		memlist = session.selectList("mapper.member.selectAllMemberList"); 
		return memlist; 
	 }
	 public List<MemberVO> selectMemberByPwd(int pwd)
	 {
		 sqlMapper = getInstance();
		 SqlSession session = sqlMapper.openSession();
		 List<MemberVO> memberList = null;
		 memberList = session.selectList("mapper.member.selectMemberByPwd",pwd);
		 return memberList;
	 }
	public MemberVO selectmemberById(String id)
	{
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = session.selectOne("mapper.member.selectMemberById",id);
		return memberVO;
	}
}
