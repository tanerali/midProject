package dao;

import model.users.User;

public class UserDao {
	private static UserDao instance;
	
	private UserDao() {
	}
	
	//thread-safe singleton optimized for performance 
	//with double-checked locking
	public static UserDao getInstance() {
		if (instance == null) {
			synchronized(UserDao.class) {
				if (instance == null) {
					instance = new UserDao();
				}
			}
		}
		return instance;
	}
	

	public User getUser(String userName) {
		//TODO
		return null;
	}
	
	public boolean existsAndAuthorized(String userName, String password) {
		//TODO
		
		return false;
		
	}

	public boolean addUser(String userName, String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
