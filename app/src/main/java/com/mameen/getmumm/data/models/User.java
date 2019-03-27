package com.mameen.getmumm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("username")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("level")
    @Expose
    private String level;

    @SerializedName("api_token")
    @Expose
    private String api_token;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}
