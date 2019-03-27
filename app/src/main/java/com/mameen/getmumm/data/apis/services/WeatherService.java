package com.mameen.getmumm.data.apis.services;

import com.mameen.getmumm.data.apis.responses.WeatherResponse;

import retrofit2.Callback;

public interface WeatherService {

    void getWeather(String place, String appid
            , Callback<WeatherResponse> callback);
}
