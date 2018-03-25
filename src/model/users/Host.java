package model.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Demo;
import model.Post;

//extends user because host is also a user, but has posts
public class Host extends User {

	private List<Post> hostedPosts;

	public Host(int userID, String email, String password, String account) {
		super(userID, email, password, account);
		this.setHostedPosts(new ArrayList<>());
	}

	public void postNew(Post post){
		Demo.postsAndCommentsInDB.put(post, new ArrayList<>());
		hostedPosts.add(post);
	}

	public boolean deletePost(Post post){
		if (Demo.postsAndCommentsInDB.get(post) != null) {
			Demo.postsAndCommentsInDB.remove(post);
			hostedPosts.remove(post);
			return true;
		}
		return false;
	}


	public List<Post> getHostedPosts() {
		return Collections.unmodifiableList(hostedPosts);
	}

	public void setHostedPosts(List<Post> hostedPosts) {
		this.hostedPosts = hostedPosts;
	}

}
