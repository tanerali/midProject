package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAO;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		System.out.println(title + " " + description + " " + price);
		PostDAO dao = PostDAO.getInstance();
		try {
			dao.postPlace("HOTEL", title, 10, 1, LocalDate.now(), description);
			RequestDispatcher view = request.getRequestDispatcher("HostPage.html");
			view.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
