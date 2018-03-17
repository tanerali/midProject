package airbnb;

import airbnb.users.Comment;
import airbnb.users.User;

public interface DBManager {
	public boolean addAccount(User user);
	
	public boolean removeAccount(User user);
	
	public User findAccount(User user);
	
	public boolean addPost(Post post);
	
	public boolean removePost(Post post);
	
	public Post findPost(Post post);
	
	public boolean changeToBooked(Post post);
	
	//also show this in notifications for receiving user
	public void sendMessage(String message, User user);
	
	//a user can leave comments for a post, whereas a host
	//can leave comments both for posts and their guests 
	public void addComment(Comment comment, ICommentable commentable);
	
	public boolean userAllowedToComment();
}
