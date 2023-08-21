package caluculator;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/sub")
public class Sub extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=Integer.parseInt(arg0.getParameter("x"));
		int b=Integer.parseInt(arg0.getParameter("y"));
		int result=a-b;
		arg1.getWriter().print("the sub staraction is"+result);
		
		
		

	}

}
