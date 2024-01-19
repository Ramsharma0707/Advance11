package in.co.rays.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeaderInfo")
public class HeaderInfo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration e=req.getHeaderNames();
		
		while (e.hasMoreElements()) {
			String name= (String) e.nextElement();
			
			String value=req.getHeader(name);
			
			System.out.println(name+"="+value);
			
		}
	}
	

}
