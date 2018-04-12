package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import dao.PostDAO;
import model.Post;
import model.Post.Type;

public class PostManager {

	public enum Filter {
		Date, Rating
	}

	// userID -> List of posts
	private static Map<Integer, List<Post>> userPosts;
	// postID -> Post
	private static Map<Integer, Post> postByID;
	// userID -> Visited Posts
	private static Map<Integer, List<Post>> visitedPlaces;
	// type of place -> number of places
	private static Map<Type, Integer> allTypesOfPlaces;
	// all Posts
	private static Set<Post> allPosts;

	private static volatile PostManager instance;

	private PostManager() {

		allPosts = new TreeSet<>();
		userPosts = new ConcurrentHashMap<>();
		postByID = new ConcurrentHashMap<>();
		visitedPlaces = new ConcurrentHashMap<>();
		allTypesOfPlaces = new ConcurrentHashMap<>();

	}

	public static PostManager getInstance() {
		synchronized (PostManager.class) {
			if (PostManager.instance == null) {
				PostManager.instance = new PostManager();
			}
		}
		return PostManager.instance;
	}

	public ArrayList<Post> getAllPosts() {
		return PostDAO.getInstance().getAllPosts();
	}
}
