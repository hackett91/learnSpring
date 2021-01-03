package com.capcon.rest.webservices.orderingservice.Model.User;

import com.capcon.rest.webservices.orderingservice.Model.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
