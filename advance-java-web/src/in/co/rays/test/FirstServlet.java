package in.co.rays.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In do get method!!!!!!!!!");
		

		
		//resp.sendRedirect("SecondServlet");
		
		//RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		//rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in dopost method");
		
		String fname=req.getParameter("firstName");
		String lname=req.getParameter("lastName");
	//	String login=req.getParameter("loginId");
	//	String pass=req.getParameter("password");
	//	String dob=req.getParameter("dob");
	//	String address=req.getParameter("address");
		
		System.out.println(fname);
		System.out.println(lname);
	//	System.out.println(login);
	//	System.out.println(pass);
	//	System.out.println(dob);
	//	System.out.println(address);
		
	//	resp.sendRedirect("SecondServlet");
		RequestDispatcher rd=req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);
		
		System.out.println("jai shree RAM");
	}
}
