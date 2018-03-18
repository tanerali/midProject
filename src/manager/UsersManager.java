package manager;

import java.util.ArrayList;
import java.util.Map;

import airbnb.users.User;

//Singleton manager class 

public class UsersManager {

	private Map<String, User> registerredUsers;// username -> user
	private Map<String, User> registerredUsersByEmail;// email -> user
	private Map<Integer, User> registerredUsersById; // id -> user
	private Map<String, ArrayList<String>> posts; // username -> set of posts
	private static UsersManager instance;
	// TODO
	// private constructor + getInstance() method
	// list all users
	// get user ( by id ,by email ,by username)
	// validate login method
	// registrate method
	// validate for email,account
	// method which checks if theres a user
	// edit firstName of user
	// edit lastName of user
	// edit .... of user
	// get all posts
	// add profile pic
	// ...etc
}
