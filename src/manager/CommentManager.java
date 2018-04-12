package manager;

import java.util.ArrayList;

import dao.CommentDAO;
import model.Comment;

public class CommentManager {
	private CommentDAO commentDAO = CommentDAO.getInstance();
	
	public void getAllCommentsForPost(int postID) {
		ArrayList<Comment> commentsForPost = commentDAO.getAllCommentsForPost(postID);
		
	}
}
