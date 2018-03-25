package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager userManager = UserManager.getInstance();
       
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
		
        if(userManager.login(userName, password) != null) {
			//return JSP with user profile page
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
		userManager.register(email, userName, password);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        userManager.editUserDetails(email, userName, password);
	}
	
	

}
