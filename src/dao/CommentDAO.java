package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manager.DBManager;
import model.Comment;

public class CommentDAO {
	private static CommentDAO instance;
	private Connection connection = DBManager.getInstance().getConnection();

	private CommentDAO() {
	}
	// thread-safe singleton optimized for performance
	// with double-checked locking
	public static CommentDAO getInstance() {
		if (instance == null) {
			synchronized (CommentDAO.class) {
				if (instance == null) {
					instance = new CommentDAO();
				}
			}
		}
		return instance;
	}

	//get all comments that are made for a given posts when
	//user clicks on posts to look at it in more detail
	public ArrayList<Comment> getAllCommentsForPost(int postID) {
		ArrayList<Comment> comments = new ArrayList<>();
		String sqlQuery = "SELECT u.user, c.content " + 
				"FROM COMMENTS c JOIN USERS u " + 
				"ON c.user_id = u.id " + 
				"WHERE post_id = ?";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			ps.setInt(1, postID);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Comment comment = new Comment(resultSet.getString(1), resultSet.getString(2));
				comments.add(comment);
			}
		} catch (SQLException e) {
			System.out.println("Couldnt get all posts; "+ e.getMessage());
		}
		return comments;
	}
}
