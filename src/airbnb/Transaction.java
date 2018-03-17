package airbnb;

import java.time.LocalDate;

import airbnb.users.User;

public class Transaction {
	private LocalDate date;
	private double amount;
	private User payer;
	private User recipient;
}
