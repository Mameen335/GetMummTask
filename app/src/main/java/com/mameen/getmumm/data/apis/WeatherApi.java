package com.mameen.getmumm.data.apis;

import com.mameen.getmumm.data.apis.responses.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather")
    Call<WeatherResponse> getWeather(
            @Query("q") String place,
            @Query("appid") String appid);
}
