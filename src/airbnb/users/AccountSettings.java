package airbnb.users;

import airbnb.DBManager;
import airbnb.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountSettings {
    private List<Transaction> transactionHistory = new ArrayList<>();
    private List<LocalDateTime> loginHistory = new ArrayList<>();

    private DBManager dbmanager;
    
    public AccountSettings(DBManager dbmanager) {
		this.dbmanager = dbmanager;
	}
	
	public void addNewTransactionRecord(Transaction transaction) {
		transactionHistory.add(transaction);
	}
	
	public void addNewLoginRecord(LocalDateTime loginTime) {
		loginHistory.add(loginTime);
	}
	
	public void cancelAccount(User user){
		if (dbmanager.findAccount(user) != null) {
			dbmanager.removeAccount(user);    			
		}
	}
}
