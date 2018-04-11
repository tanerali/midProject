
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExploreServlet")
public class ExploreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Set<Post> allPosts = manager.PostManager.getInstance();

		RequestDispatcher view = request.getRequestDispatcher("Explore.jsp");
		view.forward(request, response);
	}

}
