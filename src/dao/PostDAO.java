package dao;

import java.sql.Connection;
import java.util.ArrayList;

import manager.DBManager;
import model.Post;

public class PostDAO {
	private static PostDAO instance;
	private Connection connection = DBManager.getInstance().getConnection();

	private PostDAO() {
	}

	// thread-safe singleton optimized for performance
	// with double-checked locking
	public static PostDAO getInstance() {
		if (instance == null) {
			synchronized (PostDAO.class) {
				if (instance == null) {
					instance = new PostDAO();
				}
			}
		}
		return instance;
	}

	public void changeToBooked() {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Post> getAllPosts() {
		//TODO
		return null;
	}
}
