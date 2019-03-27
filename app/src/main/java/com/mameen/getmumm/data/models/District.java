package com.mameen.getmumm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class District implements Serializable {

    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("title")
    @Expose
    private String title;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
