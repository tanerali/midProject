package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
	// thread-safe singleton optimized for performance
	// with double-checked locking
	public static UserDAO getInstance() {
		if (instance == null) {
			synchronized (UserDAO.class) {
				if (instance == null) {
					instance = new UserDAO();
				}
			}
		}
		return instance;
	}

	public User getUser(String email) {
		String sqlQuery = "SELECT * FROM USERS WHERE email = ?";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), 
					resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9), 
					resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), 
					LocalDate.parse(resultSet.getString(13)), resultSet.getString(14));
			return user;
			
		} catch (SQLException e) {
			System.out.println("Couldnt get user; " + e.getMessage());
		}
		return null;
	}

	public boolean existsAndAuthorized(String email, String password) {
		// TODO
		String sqlQuery = "SELECT * FROM USERS WHERE email = ?";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			result.next();
			if (result.getString(6).equals(password)) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Couldnt verify if user exists and is authorized; " + e.getMessage());
		}
		return false;
	}

	public boolean addUser(String email, String userName, String password, String firstName,
			String lastName, int age, String gender, String city,
			String country, String photo, String description,
			LocalDate birthDate, String telNumber) throws SQLException {
		
		String sqlQuery = "INSERT INTO USERS (first_name, last_name, email, user, password, " +
				"age, gender, city, country, photo, description, birth_date, " +
				"telephone_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1,firstName);
		ps.setString(2,lastName);
		ps.setString(3,email);
		ps.setString(4,userName);
		ps.setString(5,password);
		ps.setInt(6,age);
		ps.setString(7,gender);
		ps.setString(8,city);
		ps.setString(9,country);
		ps.setString(10,photo);
		ps.setString(11,description);
		ps.setObject(12,birthDate);
		ps.setString(13,telNumber);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public void editUser() {
		
	}
}
