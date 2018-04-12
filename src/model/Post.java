package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Post implements ICommentable, Comparable<Post> {

	public enum Type {
		HOSTEL, HOTEL, APARTMENT, COTTAGE
	}

	private int postID;
	private int userID;
	private String title;
	private Type typeOfPlace;
	private LocalDate dateOfUpload;
	private double price;
	private String description;
	private Set<String> gallery; // every element holds a path to an image
	private Set<Integer> likes;
	private List<Comment> comments;

	public Post(int postID, int userID, String title, String typeOfPlace, LocalDate dateOfUpload, double price,
			String description) {
		this.postID = postID;
		this.userID = userID;
		this.title = title;
		this.setTypeOfPlace(typeOfPlace);
		this.dateOfUpload = dateOfUpload;
		this.price = price;
		this.description = description;
		this.gallery = gallery;
		this.likes = likes;
		this.comments = comments;
	}

	private void setTypeOfPlace(String typeOfPlace2) {
		if (typeOfPlace2.equals(Type.APARTMENT.toString())) {
			this.setTypeOfPlace(Type.APARTMENT);

		} else if (typeOfPlace2.equals(Type.HOSTEL.toString())) {
			this.setTypeOfPlace(Type.HOSTEL);

		} else if (typeOfPlace2.equals(Type.HOTEL.toString())) {
			this.setTypeOfPlace(Type.HOTEL);

		} else if (typeOfPlace2.equals(Type.COTTAGE.toString())) {
			this.setTypeOfPlace(Type.COTTAGE);

		}
	}

	public void checkAvailability(LocalDate dateOfStay, int periodDays) {
		// check in db whether booked for those dates
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Type getTypeOfPlace() {
		return typeOfPlace;
	}

	public void setTypeOfPlace(Type typeOfPlace) {
		this.typeOfPlace = typeOfPlace;
	}

	public LocalDate getDateOfUpload() {
		return dateOfUpload;
	}

	public void setDateOfUpload(LocalDate dateOfUpload) {
		this.dateOfUpload = dateOfUpload;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getGallery() {
		return Collections.unmodifiableSet(gallery);
	}

	public void setGallery(Set<String> gallery) {
		this.gallery = gallery;
	}

	public Set<Integer> getLikes() {
		return Collections.unmodifiableSet(likes);
	}

	public void setLikes(Set<Integer> likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int compareTo(Post o) {
		return this.dateOfUpload.compareTo(o.getDateOfUpload());
	}

}
