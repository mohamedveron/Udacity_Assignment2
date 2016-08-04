package com.example.esc.assignment1;

/**
 * Created by Mohamed AbdEl Mohaimen Mohamed on 7/28/2016.
 */

// This class represents post details
public class Post {
    private String name;
    private  String content;
    private String comments;
    private String likes;
    private String shares;
    private String profile;
    private String postImage;

    public Post(){

    }

    public Post(String content, String name, String posts, String likes, String shares, String profile, String postImage) {
        this.content = content;
        this.name = name;
        this.comments = posts;
        this.likes = likes;
        this.shares = shares;
        this.profile = profile;
        this.postImage = postImage;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
