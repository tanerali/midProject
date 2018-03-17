package airbnb.users;

import java.util.ArrayList;
import java.util.List;

import airbnb.DBManager;
import airbnb.Post;

//extends user because host is also a user, but has posts
public class Host extends User{
    private List<Post> hostedPosts = new ArrayList<>();
    
    public Host(DBManager dbmanager) {
		super(dbmanager);
	}

	public void postNew(Post post){
    		getDbmanager().addPost(post);
    		hostedPosts.add(post);
    }

    public boolean deletePost(Post post){
    		if (getDbmanager().findPost(post) != null) {
    			getDbmanager().removePost(post);
        		hostedPosts.remove(post);
        		return true;
    		}
    		return false;
    }
}
