package manager;

import java.util.ArrayList;
import java.util.Map;
import dao.UserDao;
import model.users.User;

//Singleton manager class 

public class UserManager {

	private Map<String, User> registerredUsers;// username -> user
	private Map<String, User> registerredUsersByEmail;// email -> user
	private Map<Integer, User> registerredUsersById; // id -> user
	private Map<String, ArrayList<String>> posts; // username -> set of posts
	private volatile static UserManager instance;
	private UserDao userDao = UserDao.getInstance();
	
	//singleton
	private UserManager() {
		super();
	}
	
	//double-checked locking for better performance by reducing
	//use of synchronization
	public static UserManager getInstance() {
		if (instance == null) {
			synchronized(UserManager.class) {
				if(instance == null) {
					instance = new UserManager();
				}
			}			
		}
		return instance;
	}

	// get user ( by id ,by email ,by username)
	// add profile pic
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		if(userDao.existsAndAuthorized(userName, password) ) {
			//return user page with user's details
			return userDao.getUser(userName);
		}
		return null;
	}
	// registrate method
	public boolean register(String email, String userName, String password) {
		// validate for email, account
		if(validEmail(email)) {
			return userDao.addUser(email, userName, password);
		}
		else {
			//display invalid email message
			return false;
		}
	}
	
	
	private boolean validEmail(String email) {
		// TODO Auto-generated method stub
		if(email.contains("@")) {
			return true;
		}
		return false;
	}

	// list all users
	public void getAllUsers() {
		
	}
	
	public void editUserDetails(String email, String userName, String password) {
		if(email != null) {
			userDao.editUser(email);
		}
	}
}
