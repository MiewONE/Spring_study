package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/Member")
public class MemberServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		MemberDAO dao = new MemberDAO();
		List list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
	    out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td></tr>");
		
	    for( int i=0;i<list.size();i++)
	    {
	    	MemberVO memberVO = (MemberVO) list.get(i);
	    	String id=memberVO.getId();
			String pwd = memberVO.getPwd();
			String name=memberVO.getName();
			String email=memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>"+id+"</td><td>"+
				                pwd+"</td><td>"+
				                name+"</td><td>"+
				                email+"</td><td>"+
				                joinDate+"</td></tr>");	
	    }
	}

}