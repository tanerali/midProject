package airbnb;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import airbnb.users.Comment;;

public class Post implements ICommentable{
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

    public void checkAvailability(){

    }

    public void calculateCost(){

    }
}
