package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginTest
 */
@WebServlet("/loginTest")
public class loginTest extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_pw");
		
		String admin = "admin";
		
		String data = null;
		if((id.equals("")||id.length()==0) || (pwd.equals("")|| pwd.length()==0))
		{
			data = "<html> <body> <h1> �ٽ� �α����ϼ��� </h1> <a href='/pro06/test01/login.html'>�α��� �ϱ�</a></body></html>";
			
		}else if(id.equals("admin"))
		{
			data = "<html> <body> <h1> �α��� ���� !</h1> <input type=\"button\" value=\"ȸ�� ����\"><input type=\"button\" value=\"ȸ�� ����\"></body></html>";
		}
		else
		{
			data = "<html> <body> <h1> �α��� ! </h1></body></html>";
		}
		out.print(data);
	}

}
