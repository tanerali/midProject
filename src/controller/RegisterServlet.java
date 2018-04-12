package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import manager.UserManager;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private UserManager userManager = UserManager.getInstance();
//	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = 
//				bcrypt.encode
				request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = 0;
		if (!request.getParameter("age").isEmpty()) {
			age = Integer.parseInt(request.getParameter("age"));
		}
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		// TODO photo
		String photo = request.getParameter("photo");
		String description = request.getParameter("description");
		LocalDate birthDate = null;
		if (!request.getParameter("birthDate").isEmpty()) {
			birthDate = LocalDate.parse(request.getParameter("birthDate"));
		}
		String telNumber = request.getParameter("telNumber");

		try {
			if (userManager.register(email, userName, password, firstName, lastName, age, gender, 
					city, country, photo, description, birthDate, telNumber)) {
				request.getRequestDispatcher("profile.html").forward(request, response);				
			} else {
				response.sendRedirect("register.html");
			}
		} catch (SQLException e) {
			System.out.println("Coudlnt add user; "+ e.getMessage());
		}
		
	}
}
