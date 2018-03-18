package airbnb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import airbnb.users.Comment;;

public class Post implements ICommentable {

	public enum Type {
		HOSTEL, HOTEL, APARTMENT, COTTAGE
	}

	private int postID;
	private int userID;
	private String title;
	private Type typeOfPlace;
	private LocalDate dateOfUpload;
	private String description;
	private Set<String> gallery; // every element holds a path to an image
	private Set<Integer> likes;
	private ArrayList<Comment> comments;

	public Post(int postID, int userID, Set<String> gallery, String title, Type typeOfPlace, LocalDate dateOfUpload) {

		this.postID = postID;
		this.userID = userID;
		this.gallery = gallery;
		this.title = title;
		this.typeOfPlace = typeOfPlace;
		this.dateOfUpload = dateOfUpload;

		this.likes = new TreeSet<>();
		this.comments = new ArrayList<>();

	}

	public void checkAvailability() {

	}

	public void calculateCost() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getGallery() {
		return gallery;
	}

	public void setGallery(Set<String> gallery) {
		this.gallery = gallery;
	}

	public Set<Integer> getLikes() {
		return likes;
	}

	public void setLikes(Set<Integer> likes) {
		this.likes = likes;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

}
