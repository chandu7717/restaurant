package Life;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hi")
public class Service implements Servlet {
	
	//when we hit the url at the first time 
	//step:1
	static
	{
		System.out.println("class is loaded");
	}
	
	//Step :2
	public Service() {
		System.out.println("object for the service class is created");
	}
	

	@Override
	//step:5
	public void destroy() {
System.out.println("the destroy method is called");		
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
//step:3
		System.out.println("init method is called");
	}

	@Override
	//step:4
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
System.out.println("the service method is called");		
	}

}
