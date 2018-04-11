package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import exceptions.UserUnauthorizedException;
import manager.DBManager;
import model.users.User;

public class UserDAO {
	private static UserDAO instance;
	private Connection connection = DBManager.getInstance().getConnection();
	//private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	private UserDAO() {
	}

	//thread-safe singleton optimized for performance 
	//with double-checked locking
	public static UserDAO getInstance() {
		if (instance == null) {
			synchronized(UserDAO.class) {
				if (instance == null) {
					instance = new UserDAO();
				}
			}
		}
		return instance;
	}


	public User getUser(String userName) {
		String sqlQuery = "SELECT * FROM airbnb WHERE user_name = ?";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
			ps.setString(1, userName);
			ResultSet resultSet = ps.executeQuery();
			User user = new User(
					//TODO set correct column index
					resultSet.getInt(1),
					resultSet.getString(1),
					resultSet.getString(1),
					resultSet.getString(1)
					);
			return user;
		} catch (SQLException e) {
			System.out.println("Couldnt get user; "+ e.getMessage());
		}
		return null;
	}

	public boolean existsAndAuthorized(String userName, String password)
			throws UserUnauthorizedException {
		//TODO
		String sqlQuery = "SELECT * FROM airbnb WHERE user_name = ?";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			ps.setString(1,userName);
			ResultSet result = ps.executeQuery();
			if (result.getString(1).equals(password)) {
				return true;
			}
			else {
				throw new UserUnauthorizedException();
			}
		} catch (SQLException e) {
			System.out.println("Couldnt verify if user exists and is authorized; "+
					e.getMessage());
		}
		return false;

	}

	public boolean addUser(String userName, String email, String password) {
		// TODO Auto-generated method stub
		String sqlQuery = "INSERT INTO airbnb () VALUES ()";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			ps.setString(1,userName);
			ps.setString(1,email);
		//	ps.setString(1,bCryptPasswordEncoder.encode(password));
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Coudlnt add new user to db; "+ e.getMessage());
		}
		return false;
	}

	public void editUser(String email) {

	}
}
