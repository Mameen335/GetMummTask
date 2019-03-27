package com.mameen.getmumm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FeedBack implements Serializable {

    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("user_id")
    @Expose
    private int user_id;

    @SerializedName("meeting_id")
    @Expose
    private int meeting_id;

    @SerializedName("comment")
    @Expose
    private String comment;

    @SerializedName("user")
    @Expose
    private String user;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
