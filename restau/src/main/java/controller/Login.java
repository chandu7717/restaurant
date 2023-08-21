package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Customer;


@WebServlet("/sign")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("email");
//		resp.getWriter().print(name);
		String pass = req.getParameter("pass");
//		resp.getWriter().print(pass);
		Mydao dao = new Mydao();
		
		//varifying that email is exist
		if(name.equals("admin@jsp.com") && pass.equals("admin"))
		{
			resp.getWriter().print("<h1 style='color:blue'>Login Succesfull</h1>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
		}
		else {
			Customer customer = dao.fetchByEmail(name);
		if (customer == null) {
			resp.getWriter().print("<h1 style='color:brown'>Invalid Email</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			if (pass.equals(customer.getPassword())) {
				resp.getWriter().print("<h1 style='color:blue'>Login Succesfull</h1>");
				req.getRequestDispatcher("CustomerHomePage.html").include(req, resp);
			} else {
				resp.getWriter().print("<h1 style='color:green'>Invalid Password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
		}

	}

}
