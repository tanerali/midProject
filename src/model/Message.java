package model;

import java.time.LocalDateTime;

import model.users.User;

public class Message {

	private User fromUser;
	private User toUser;
	private LocalDateTime date;
	private String message;

	public Message(User fromUser, User toUser, String message) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.message = message;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
