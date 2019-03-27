package com.mameen.getmumm.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {

    @SerializedName("id")
    @Expose
    private int Id;

    @SerializedName("district_id")
    @Expose
    private int district_id;

    @SerializedName("user_id")
    @Expose
    private int user_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("contact_name_1")
    @Expose
    private String contact_name_1;

    @SerializedName("contact_name_2")
    @Expose
    private String contact_name_2;

    @SerializedName("contact_name_3")
    @Expose
    private String contact_name_3;

    @SerializedName("contact_name_4")
    @Expose
    private String contact_name_4;

    @SerializedName("contact_number_1")
    @Expose
    private String contact_number_1;

    @SerializedName("contact_number_2")
    @Expose
    private String contact_number_2;

    @SerializedName("contact_number_3")
    @Expose
    private String contact_number_3;

    @SerializedName("contact_number_4")
    @Expose
    private String contact_number_4;

    @SerializedName("email_person_1")
    @Expose
    private String email_person_1;

    @SerializedName("email_person_2")
    @Expose
    private String email_person_2;

    @SerializedName("email_person_3")
    @Expose
    private String email_person_3;

    @SerializedName("email_person_4")
    @Expose
    private String email_person_4;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("facebook")
    @Expose
    private String facebook;

    @SerializedName("employee")
    @Expose
    private String employee;

    @SerializedName("level_employee")
    @Expose
    private String level_employee;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("lat")
    @Expose
    private String lat;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("notes")
    @Expose
    private String notes;

    @SerializedName("twitter")
    @Expose
    private String twitter;

    @SerializedName("instagram")
    @Expose
    private String instagram;

    @SerializedName("linkedin")
    @Expose
    private String linkedin;

    @SerializedName("tgate")
    @Expose
    private boolean tgate;

    @SerializedName("meetings")
    @Expose
    private ArrayList<Meeting> meetings;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact_name_1() {
        return contact_name_1;
    }

    public void setContact_name_1(String contact_name_1) {
        this.contact_name_1 = contact_name_1;
    }

    public String getContact_name_2() {
        return contact_name_2;
    }

    public void setContact_name_2(String contact_name_2) {
        this.contact_name_2 = contact_name_2;
    }

    public String getContact_name_3() {
        return contact_name_3;
    }

    public void setContact_name_3(String contact_name_3) {
        this.contact_name_3 = contact_name_3;
    }

    public String getContact_name_4() {
        return contact_name_4;
    }

    public void setContact_name_4(String contact_name_4) {
        this.contact_name_4 = contact_name_4;
    }

    public String getContact_number_1() {
        return contact_number_1;
    }

    public void setContact_number_1(String contact_number_1) {
        this.contact_number_1 = contact_number_1;
    }

    public String getContact_number_2() {
        return contact_number_2;
    }

    public void setContact_number_2(String contact_number_2) {
        this.contact_number_2 = contact_number_2;
    }

    public String getContact_number_3() {
        return contact_number_3;
    }

    public void setContact_number_3(String contact_number_3) {
        this.contact_number_3 = contact_number_3;
    }

    public String getContact_number_4() {
        return contact_number_4;
    }

    public void setContact_number_4(String contact_number_4) {
        this.contact_number_4 = contact_number_4;
    }

    public String getEmail_person_1() {
        return email_person_1;
    }

    public void setEmail_person_1(String email_person_1) {
        this.email_person_1 = email_person_1;
    }

    public String getEmail_person_2() {
        return email_person_2;
    }

    public void setEmail_person_2(String email_person_2) {
        this.email_person_2 = email_person_2;
    }

    public String getEmail_person_3() {
        return email_person_3;
    }

    public void setEmail_person_3(String email_person_3) {
        this.email_person_3 = email_person_3;
    }

    public String getEmail_person_4() {
        return email_person_4;
    }

    public void setEmail_person_4(String email_person_4) {
        this.email_person_4 = email_person_4;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getLevel_employee() {
        return level_employee;
    }

    public void setLevel_employee(String level_employee) {
        this.level_employee = level_employee;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public boolean isTgate() {
        return tgate;
    }

    public void setTgate(boolean tgate) {
        this.tgate = tgate;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }
}
