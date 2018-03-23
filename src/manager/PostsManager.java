package manager;

import java.util.Map;
import java.util.Set;

import airbnb.Post;

public class PostsManager {

	public enum Filter {
		Date, Likes
	}

	// userID -> Posts
	private static Map<Integer, Set<Post>> userPosts;
	// postID -> Post
	private static Map<Integer,Post> postByID;
	// userID -> Liked Posts
	private static Map<Integer,Set<Post>> likedPosts;
	// type of place -> number of places
	private static Map<Type,Integer> 
}
