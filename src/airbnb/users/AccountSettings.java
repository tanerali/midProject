package airbnb.users;

import airbnb.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AccountSettings {
    enum NotificationMethod {
        EMAIL, PUSH, TEXTMSG
    }
    enum NotificationSubject {
        MESSAGE, REMINDERS, PROMOTIONSTIPS, POLICYANDCOMMUNITY, ACCOUNTSUPPORT
    }
    enum PaymentMethod {

    }
    enum PrivacyPreference {
        SOCIAL, SEARCHENGINES
    }



    private Map<NotificationSubject, List<NotificationMethod>> notificationSettings;
    private List<PaymentMethod> paymentMethods;
    private List<PaymentMethod> payoutPreferences;
    private List<Transaction> transactionHistory;
    private Map<PrivacyPreference, Boolean> privacyPreferences;
    private List<LocalDate> loginHistory;

    public void cancelAccount(){}
}
