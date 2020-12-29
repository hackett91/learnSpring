package com.capcon.rest.webservices.orderingservice.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.security.cert.CertPathBuilder;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    // GET /users
    // retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }
    // GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        if (user==null) {
            throw new UserNotFoundException("id-"+ id);
        }
        return user;
    }
    //CREATED
    // input - details of user
    // output - CREATED & REturn the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
        //CREATED status
        // /users/4
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        // 201 response created status
        return ResponseEntity.created(location).build();
    }

}
