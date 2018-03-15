package airbnb.users;

import java.util.List;

import airbnb.Post;

//extends user because host is also a user,
// just has listings as well
public class Host extends User{
    private List<Post> hostedPosts;

    public void postNew(){}

    public void deletePost(){}


}
