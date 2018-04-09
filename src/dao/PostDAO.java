package dao;

public class PostDAO {
	private static PostDAO instance;
	
	private PostDAO() {
	}
	
	//thread-safe singleton optimized for performance 
	//with double-checked locking
	public static PostDAO getInstance() {
		if (instance == null) {
			synchronized(PostDAO.class) {
				if (instance == null) {
					instance = new PostDAO();
				}
			}
		}
		return instance;
	}

	public void changeToBooked() {
		// TODO Auto-generated method stub
		
	}
}
