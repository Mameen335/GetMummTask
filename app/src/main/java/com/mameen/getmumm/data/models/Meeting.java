package com.mameen.getmumm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Meeting implements Serializable {

    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("company_id")
    @Expose
    private int company_id;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("feedback")
    @Expose
    private ArrayList<FeedBack> feedBacks;

    @SerializedName("company")
    @Expose
    private ArrayList<Company> companies;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<FeedBack> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(ArrayList<FeedBack> feedBacks) {
        this.feedBacks = feedBacks;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }
}
