package model.users;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import controller.Demo;
import model.Comment;
import model.ICommentable;
import model.Message;
import model.Post;

public class User implements ICommentable {
	//first_name, last_name, email, user, password, " +
	//"age, gender, city, country, photo, description, birth_date, " +
	//"telephone_number
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private int age;
	private String gender;
	private String city;
	private String country;
	private String photo;
	private String description;
	private LocalDate birthDate;
	private String telNumber;
	private List<Comment> reviewsGiven = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();
	private Map<String, List<Post>> listsCreated = new TreeMap<>();

	public User(int userID, String email, String password, String account) {
		this.email = email;
		this.password = password;
		this.userID = userID;
		this.username = account;
	}
	
	public User(int userID, String firstName, String lastName, String email, String username, String password, int age,
			String gender, String city, String country, String photo, String description, LocalDate birthDate,
			String telNumber) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.photo = photo;
		this.description = description;
		this.birthDate = birthDate;
		this.telNumber = telNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public List<Comment> getReviewsGiven() {
		return Collections.unmodifiableList(reviewsGiven);
	}

	public void setReviewsGiven(List<Comment> reviewsGiven) {
		this.reviewsGiven = reviewsGiven;
	}

	public List<Message> getMessages() {
		return Collections.unmodifiableList(messages);
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Map<String, List<Post>> getListsCreated() {
		return Collections.unmodifiableMap(listsCreated);
	}

	public void setListsCreated(Map<String, List<Post>> listsCreated) {
		this.listsCreated = listsCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userID != other.userID)
			return false;
		return true;
	}

}
