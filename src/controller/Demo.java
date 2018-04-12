package controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Comment;
import model.Post;
import model.users.User;

public class Demo {

	// simulate database
	public static Map<Post, List<Comment>> postsAndCommentsInDB = new TreeMap<>();
	public static Map<User, List<Comment>> usersAndCommentsInDB = new TreeMap<>();

	public static void main(String[] args) {
	}
}
