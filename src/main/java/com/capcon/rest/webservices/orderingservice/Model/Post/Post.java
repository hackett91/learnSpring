package com.capcon.rest.webservices.orderingservice.Model.Post;

public class Post {


    private Integer post_id;
    private String title;
    private String content;

    public Post(Integer post_id, String title, String content) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
