package airbnb.users;

import java.time.LocalDate;

public class Comment {

	private int commentID;
	private int postID;
	private int userID;
	private String content;
	private LocalDate date;
	private String username;

	public Comment(int commentID, int postID, int userID, String content, LocalDate date, String username) {
		this.commentID = commentID;
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		this.date = date;
		this.username = username;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
