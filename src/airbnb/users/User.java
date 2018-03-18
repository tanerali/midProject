package airbnb.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import airbnb.ICommentable;
import airbnb.Post;

public class User implements ICommentable {
	private int userID;
	private String email;
	private String password;
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String city;
	private String country;
	// photo
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
		return reviewsGiven;
	}

	public void setReviewsGiven(List<Comment> reviewsGiven) {
		this.reviewsGiven = reviewsGiven;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Map<String, List<Post>> getListsCreated() {
		return listsCreated;
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
