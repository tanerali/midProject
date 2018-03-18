package airbnb.users;

import java.util.ArrayList;
import java.util.List;

import airbnb.Post;

//extends user because host is also a user, but has posts
public class Host extends User {

	private List<Post> hostedPosts;

	public Host(int userID, String email, String password, String account) {
		super(userID, email, password, account);
		this.setHostedPosts(new ArrayList<>());
	}

	public List<Post> getHostedPosts() {
		return hostedPosts;
	}

	public void setHostedPosts(List<Post> hostedPosts) {
		this.hostedPosts = hostedPosts;
	}

}
