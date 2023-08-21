package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Mydao;
import dto.Customer;


//this to map the action url to this class(should be same as action_and case sensitive)
@WebServlet("/signup")
@MultipartConfig

//make as class as servlet class 
public class Signup extends HttpServlet {
	@Override
	// when there is form we want data should be secure so we write doPost()
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// logic to receive value from fronted
		String fullname = req.getParameter("fullname");
		resp.getWriter().print(fullname);
		// password
		String password = req.getParameter("password");
		resp.getWriter().print(password);
		// mobile number
		long mobile = Long.parseLong(req.getParameter("mobile"));
		resp.getWriter().print(mobile);
		// gmail id
		String gmail = req.getParameter("email");
		resp.getWriter().print(gmail);
		// gender
		String gender = req.getParameter("gender");
		resp.getWriter().print(gender);
		// country
		String country = req.getParameter("country");
		resp.getWriter().print(country);
		// dob .....this is the logic to convert String to the date
		LocalDate date = LocalDate.parse("dob");
		resp.getWriter().print(date);
//clauculating the age
		int age = Period.between(date, LocalDate.now()).getYears();
//		resp.getWriter().print(age);

//logic for the storig the photo
		Part pic = req.getPart("picture");
		byte picture[] = null;
		picture = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);

//loading values inside the object
//		Customer cust = new Customer();
//		cust.setAge(age);
//		cust.setCountry(country);
//		cust.setDob(date);
//		cust.setEmail(gmail);
//		cust.setFullname(fullname);
//		cust.setGender(gender);
//		cust.setMobileno(mobile);
//		cust.setPassword(password);
//		cust.setPicture(picture);

		Mydao dao = new Mydao();
		// Logic to verify email and mobile number is not repeated
		if (dao.fetchByEmail(gmail) == null && dao.fetchByMobile(mobile) == null) {
			// loading values inside object
			Customer customer = new Customer();
			customer.setAge(age);
			customer.setCountry(country);
			customer.setDob(date);
			customer.setEmail(gmail);
			customer.setFullname(fullname);
			customer.setGender(gender);
			customer.setMobileno(mobile);
			customer.setPassword(password);
			customer.setPicture(picture);
			// Persisting

			dao.save(customer);

			resp.getWriter().print("<h1 style='color:orange'>Account created successfully</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1 style='color:red'> Email and mobile number should be unique </h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}

	}

}
