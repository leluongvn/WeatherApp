package com.example.weatherapi.MODEL;

public class WeatherFourDay {

    private float message ;
    private clouds clouds;
    private wind wind;

    public WeatherFourDay(float message, com.example.weatherapi.MODEL.clouds clouds, com.example.weatherapi.MODEL.wind wind) {
        this.message = message;
        this.clouds = clouds;
        this.wind = wind;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public com.example.weatherapi.MODEL.clouds getClouds() {
        return clouds;
    }

    public void setClouds(com.example.weatherapi.MODEL.clouds clouds) {
        this.clouds = clouds;
    }

    public com.example.weatherapi.MODEL.wind getWind() {
        return wind;
    }

    public void setWind(com.example.weatherapi.MODEL.wind wind) {
        this.wind = wind;
    }
}
