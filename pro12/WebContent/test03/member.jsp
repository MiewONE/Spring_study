<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec02.ex01.*"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
                <title>Insert title here</title>
            <style>
            	h1 {
            		text-align:center;
            	}
            </style>
        </head>
        <body>
        	<h1>회원 정보 출력</h1>
        	<%
        		request.setCharacterEncoding("utf-8");
        		String _name = request.getParameter("name");
        		MemberVO memberVO = new MemberVO();
        		memberVO.setName(_name);
        		MemberDAO dao = new MemberDAO();
        		List memberlist = dao.listMembers(memberVO);
        	%>
        </body>
    </html>