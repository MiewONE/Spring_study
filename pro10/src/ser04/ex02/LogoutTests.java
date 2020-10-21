package ser04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginTests
 */
@WebServlet("/Logout")
public class LogoutTests extends HttpServlet {
	ServletContext context =null;
	List user_list = new ArrayList();
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
	private void doHandle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		res.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		session.invalidate();
		List user_list = (ArrayList)context.getAttribute("user_list");
		user_list.remove(user_id);
		context.removeAttribute("user_list");
		context.setAttribute("user_list",user_list);
		out.println("<html><body>");
		out.println("<br>로그아웃</body></html>");
		/*
		 * String user_id = req.getParameter("user_id"); String user_pw =
		 * req.getParameter("user_pw"); LoginImpl loginU = new
		 * LoginImpl(user_id,user_pw); if(session.isNew()) {
		 * session.setAttribute("loginU", loginU); user_list.add(user_id);
		 * context.setAttribute("user_list",user_list); } out.println("<html><body>");
		 * //out.println("̵ " + loginUser.user_id + "<br>");
		 * out.println("Total Login Users is "+LoginImpl.total_user +"<br><br>");
		 * out.println("id is "+ loginU.user_id + "<br>"); List list =
		 * (ArrayList)context.getAttribute("user_list"); for(int i=0;i<list.size();i++)
		 * { out.println(list.get(i)+"<br>"); }
		 * out.println("<a href='logout?user_id="+user_id+"'>Logout </a>");
		 * out.println("</body></html>");
		 */
		
		
	}

}
