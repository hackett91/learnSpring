package com.capcon.rest.webservices.orderingservice.Model.Post;

import com.capcon.rest.webservices.orderingservice.Model.User.User;
import com.capcon.rest.webservices.orderingservice.Model.User.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostDaoService postDaoService;

    @GetMapping("/users/{id}/posts")
    public List<Post> getAllUserPosts(@PathVariable Integer id){
        return postDaoService.getAllUserPosts(id);
    }

    @GetMapping("/users/{id}/posts/{post_id}")
    public Post getUserPost(@PathVariable Integer id, Integer post_id){
        return postDaoService.getUserPost(id, post_id);
    }

    //CREATED
    // input - details of user
    // output - CREATED & REturn the created URI
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer id, @RequestBody Post post){

        Post savedPost = postDaoService.addUserPost(id, post);
        //CREATED status
        // /users/4/posts/3
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{post_id}")
                .buildAndExpand(savedPost.getPost_id()).toUri();
        // 201 response created status
        return ResponseEntity.created(location).build();
    }

}
