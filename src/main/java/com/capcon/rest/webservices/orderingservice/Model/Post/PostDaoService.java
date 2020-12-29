package com.capcon.rest.webservices.orderingservice.Model.Post;

import com.capcon.rest.webservices.orderingservice.Model.User.User;
import com.capcon.rest.webservices.orderingservice.Model.User.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDaoService {

    private User user;
    private Integer postsCouunt = 0;
    @Autowired
    private UserDaoService userDaoService;

    public List<Post> getAllUserPosts(Integer id) {
        this.user = userDaoService.findOne(id);
        return this.user.getAllPost();
    }

    public Post getUserPost(Integer id, Integer post_id) {
        this.user = userDaoService.findOne(id);
        List<Post> posts = user.getAllPost();
        for(Post post: posts) {
            if (post.getPost_id().equals(post_id)){
                return post;
            }
        }
        return null;
    }

    public Post addUserPost(Integer id, Post post) {
        this.user = userDaoService.findOne(id);
        if (post.getPost_id()==null) {
            post.setPost_id(++postsCouunt);
        }
        user.addPost(post);
        return post;
    }

}
