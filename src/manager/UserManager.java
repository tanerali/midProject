package manager;

import java.util.ArrayList;
import java.util.Map;

import controller.Demo;
import dao.PostDAO;
import dao.UserDAO;
import exceptions.UserUnauthorizedException;
import model.Comment;
import model.Post;
import model.users.User;

//Singleton manager class 

public class UserManager {

	private Map<String, User> registerredUsers;// username -> user
	private Map<String, User> registerredUsersByEmail;// email -> user
	private Map<Integer, User> registerredUsersById; // id -> user
	private Map<String, ArrayList<String>> posts; // username -> set of posts
	private volatile static UserManager instance;
	private UserDAO userDao = UserDAO.getInstance();
	private PostDAO postDao = PostDAO.getInstance();

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
	// get user ( by id ,by email ,by username)
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		try {
			if(userDao.existsAndAuthorized(userName, password)) {
				//return user page with user's details
				return userDao.getUser(userName);
			}
		} catch (UserUnauthorizedException e) {
			System.out.println("User is not authorized");
		}
		return null;
	}

	// registration method
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
		if(email.contains("@")) {
			return true;
		}
		return false;
	}

	public void editUserDetails(String email, String userName, String password) {
		if(email != null) {
			userDao.editUser(email);
		}
	}

	public void book(Post post) {
		postDao.changeToBooked();
	}

	public void sharePost(Post post, String emailAddress){
		//TODO
		//sendViaEmail(post, emailAddress);
	}

	public void saveToList(String listName, Post post){
		if (listsCreated.get(listName) == null) {
			listsCreated.put(listName, new ArrayList<Post>());
		}
		listsCreated.get(listName).add(post);
	}

	public void sendMessage(String messageBody, User user){
		//TODO
		//sendMessage(messageBody, user);
	}

	public void leaveComment(Comment comment, Post post) {
		//user can only leave comments for places that he has been in
		//if (userHasVisitedPlace()) {
		Demo.postsAndCommentsInDB.get(post).add(comment);
		//}
	}
}
