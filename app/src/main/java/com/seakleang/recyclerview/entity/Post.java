package com.seakleang.recyclerview.entity;

public class Post {

    int userProfile;
    String userName;
    String checkI;
    String content;
    String likeCount;
    int image;

    public Post() {
    }

    public Post(int userProfile, String userName, String checkI, String content, String likeCount, int image) {
        this.userProfile = userProfile;
        this.userName = userName;
        this.checkI = checkI;
        this.content = content;
        this.likeCount = likeCount;
        this.image = image;
    }

    public void setUserProfile(int userProfile) {
        this.userProfile = userProfile;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCheckI(String checkI) {
        this.checkI = checkI;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getUserProfile() {
        return userProfile;
    }

    public String getUserName() {
        return userName;
    }

    public String getCheckI() {
        return checkI;
    }

    public String getContent() {
        return content;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public int getImage() {
        return image;
    }
}
