package com.example.weatherapi.API;

import com.example.weatherapi.MODEL.Example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("weather")
    Call<Example> getWeather (@Query("q") String cityname,
                              @Query("appid") String apikey);

}