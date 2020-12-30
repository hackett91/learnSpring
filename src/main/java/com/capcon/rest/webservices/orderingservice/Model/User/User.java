package com.capcon.rest.webservices.orderingservice.Model.User;

import com.capcon.rest.webservices.orderingservice.Model.Post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@ApiModel(description = "All details about the user")

public class User {

    private Integer id;
    @Size(min=2, message="Name should have atleast 2 characters")
    @ApiModelProperty(notes="Name should atleast have 2 characters")
    private String name;
    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthDate;
    private List<Post> posts;

    public User(Integer id, String name, Date birthDate, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public Post getPost(Integer id) {
       return this.posts.get(id);
    }

    public List<Post> getAllPost() {
        return this.posts;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }
}
