package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import manager.DBManager;
import model.Post;

public class PostDAO {
	private static PostDAO instance;
	private Connection connection = DBManager.getInstance().getConnection();

	private static final String INSERT_POST = "INSERT INTO POSTS(type, title, price, host_id, date_of_posting, description,gallery_photos) VALUES (?,?,?,?,?,?,?);";
	private static final String SELECT_NUMBER_OF_PLACES_BY_TYPE = "";
	private static final String SELECT_ALL_PLACES = "SELECT * FROM POSTS;";
	private static int gallery_photosID = 4; // DELETE LATER !
	private static Connection con = DBManager.getInstance().getConnection();

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

	public void postPlace(String type, String title, int price, int host_id, LocalDate date_of_posting,
			String description) throws SQLException {
		PreparedStatement st = con.prepareStatement(INSERT_POST);
		st.setString(1, type);
		st.setString(2, title);
		st.setInt(3, price);
		st.setInt(4, 1);
		st.setDate(5, Date.valueOf(LocalDate.now()));
		st.setString(6, description);
		st.setInt(7, ++gallery_photosID);
		st.executeUpdate();
	}

	public ArrayList<Post> getAllPosts() {
		ArrayList<Post> posts = new ArrayList<>();
		try {
			Statement st = DBManager.getInstance().getConnection().createStatement();
			ResultSet resultSet = st.executeQuery(SELECT_ALL_PLACES);
			while (resultSet.next()) {
				posts.add(new Post(resultSet.getInt("ID"), resultSet.getInt("host_id"), resultSet.getString("title"),
						resultSet.getString("type"), resultSet.getDate("date_of_posting").toLocalDate(),
						resultSet.getInt("price"), resultSet.getString("description")));
			}
		} catch (SQLException e) {
			System.err.println("Oops,  postsDAO problem.");
		}
		return posts;
	}
}
