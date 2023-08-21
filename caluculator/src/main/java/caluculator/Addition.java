package caluculator;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/add") /// mapping to the addition
public class Addition implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String para = arg0.getParameter("x");
		String para2 = arg0.getParameter("y");
		int a = Integer.parseInt(para);
		int b = Integer.parseInt(para2);
		int result = a + b;
//		System.out.println("the sum is "+result);

		arg1.getWriter().print("<i style='color:red'>the sum is" + result + "</i>");

	}

}
