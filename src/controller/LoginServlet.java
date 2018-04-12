package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import manager.UserManager;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserManager userManager = UserManager.getInstance();
//	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = 
//				bCryptPasswordEncoder.encode
						request.getParameter("password");
		String htmlFile = null;

		if (userManager.login(email, password) != null) {
			// return user profile page
			htmlFile = "profile.html";
		} else {
			htmlFile = "loginFailed.html";
		}

		request.getRequestDispatcher(htmlFile).forward(request, response);		 
	}
}
