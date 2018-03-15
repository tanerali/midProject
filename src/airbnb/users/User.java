package airbnb.users;

import java.time.LocalDate;
import java.util.List;

import airbnb.Post;

public class User {
    public class Coupon {
        private String code;
        private LocalDate expirationDate;
        private double creditAmount;
        private String restrictions;
    }
    public class Badge {

    }

	private int userID;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
	private int age;
    private String gender;
    private String city;
	private String country;
	//photo
	private String photo;
	private String description;
    private LocalDate birthDate;
    private String telNumber;
    private String preferredLanguage;
    private String preferredCurrency;
    private List<Coupon> coupons;
    private double giftCardBalance;
    private AccountSettings accountSettings;
    private List<Badge> badges;
    private List<Comment> reviewsGiven;
    private List<Message> messages;
    private List<Notification> notifications;
    private List<String> connectedApps;



    public void book(Post listing){}

    public void sharePost(Post listing){}

    public void saveToList(Post listing){}

    public void createNewList(){}

    public void sendMessage(String messageBody){}

}
