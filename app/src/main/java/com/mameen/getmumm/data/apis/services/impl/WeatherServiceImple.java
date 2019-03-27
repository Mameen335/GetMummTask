package com.mameen.getmumm.data.apis.services.impl;

import android.util.Log;

import com.mameen.getmumm.data.apis.WeatherApi;
import com.mameen.getmumm.data.apis.responses.WeatherResponse;
import com.mameen.getmumm.data.apis.services.BaseService;
import com.mameen.getmumm.data.apis.services.WeatherService;

import retrofit2.Callback;

import io.github.sporklibrary.Spork;
import io.github.sporklibrary.annotations.BindComponent;
import retrofit2.Callback;

public class WeatherServiceImple implements WeatherService {

    static final String TAG = WeatherServiceImple.class.getSimpleName();

    @BindComponent(BaseServiceImpl.class)
    BaseService baseService;

    WeatherApi weatherApi;

    public WeatherServiceImple() {
        Spork.bind(this);
        weatherApi = baseService.getRetrofit().create(WeatherApi.class);
    }

    @Override
    public void getWeather(String place, String appid, Callback<WeatherResponse> callback) {
        try {
            weatherApi.getWeather(place, appid).enqueue(callback);
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }
}
