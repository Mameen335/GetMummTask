package com.mameen.getmumm.data.apis.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherResponse {

    @SerializedName("name")
    @Expose
    private String placeName;

    @SerializedName("main")
    @Expose
    private Temperature temperature;

    @SerializedName("weather")
    @Expose
    private ArrayList<WeatherCondition> weatherCondition;

    private class Temperature {

        @SerializedName("temp")
        @Expose
        private String temp;
    }

    public String getTemp() {
        return temperature.temp;
    }

    public void setTemp(String temp) {
        temperature.temp = temp;
    }

    private class WeatherCondition {

        @SerializedName("description")
        @Expose
        private String description;
    }

    public String getDescription() {
        return weatherCondition.get(0).description;
    }

    public void setDescription(String description) {
        weatherCondition.get(0).description = description;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
