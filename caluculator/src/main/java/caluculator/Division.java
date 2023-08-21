package caluculator;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Division extends HttpServlet
{
//@Override
//protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//	// TODO Auto-generated method stub
//			int a=Integer.parseInt(arg0.getParameter("x"));
//			int b=Integer.parseInt(arg0.getParameter("y"));
//			int result=a-b;
//			arg1.getWriter().print("the sub staraction is"+result);
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
			int a=Integer.parseInt(req.getParameter("x"));
			int b=Integer.parseInt(req.getParameter("y"));
			int result=a/b;
			resp.getWriter().print("the division is"+result);
			
			
}
			
}

