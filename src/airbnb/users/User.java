package airbnb.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import airbnb.DBManager;
import airbnb.ICommentable;
import airbnb.Post;

public class User implements ICommentable{
	private int userID;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
	private int age;
    private String gender;
    private String city;
	private String country;
	//photo
	private String photo;
	private String description;
    private LocalDate birthDate;
    private String telNumber;
    private AccountSettings accountSettings;
    private List<Comment> reviewsGiven = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private Map<String, List<Post>> listsCreated = new TreeMap<>();

    private DBManager dbmanager;

	public User(DBManager dbmanager) {
		this.dbmanager = dbmanager;
	}
	
	public DBManager getDbmanager() {
		return dbmanager;
	}

	public boolean book(Post post){
    		return dbmanager.changeToBooked(post);
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
    		dbmanager.sendMessage(messageBody, user);
    }
    
    public void leaveComment(Comment comment, Post post) {
    		//user can only leave comments for places that he has been in
    		if (dbmanager.userAllowedToComment()) {
    			dbmanager.addComment(comment, post);
    		}
    }

}
