package dao;

public class MessageDAO {
	private static MessageDAO instance;

	private MessageDAO() {
	}

	// thread-safe singleton optimized for performance
	// with double-checked locking
	public static MessageDAO getInstance() {
		if (instance == null) {
			synchronized (MessageDAO.class) {
				if (instance == null) {
					instance = new MessageDAO();
				}
			}
		}
		return instance;
	}
}
