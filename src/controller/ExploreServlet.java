package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

@WebServlet("/ExploreServlet")
public class ExploreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Post> allPosts = manager.PostManager.getInstance().getAllPosts();

		RequestDispatcher view = request.getRequestDispatcher("Explore.jsp");
		request.setAttribute("posts", allPosts);
		view.forward(request, response);
	}

}
