package com.seakleang.recyclerview.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {

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

    protected Post(Parcel in) {
        userProfile = in.readInt();
        userName = in.readString();
        checkI = in.readString();
        content = in.readString();
        likeCount = in.readString();
        image = in.readInt();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userProfile);
        dest.writeString(userName);
        dest.writeString(checkI);
        dest.writeString(content);
        dest.writeString(likeCount);
        dest.writeInt(image);
    }
}
