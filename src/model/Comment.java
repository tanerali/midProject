package model;

import java.time.LocalDate;

public class Comment {

	private int commentID;
	private int postID;
	private int userID;
	private String username;
	private String content;
	
	public Comment(String username, String content) {
		this.username = username;
		this.content = content;
	}
	
	public Comment(int commentID, int postID, int userID, String username, String content) {
		this(username, content);
		this.commentID = commentID;
		this.postID = postID;
		this.userID = userID;
	}
	
	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
