package com.codenamesid.applicationseries.openweathermvp.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    @SerializedName("dt")
    private float dt;

    @SerializedName("dt_txt")
    private String dtText;

    @SerializedName("main")
    Temp temprature;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("weather")
    List<Description> weather = new ArrayList();

    @SerializedName("speed")
    private float speed;

    @SerializedName("deg")
    private float deg;


    public Temp getTemprature() {
        return temprature;
    }

    public void setTemprature(Temp temprature) {
        this.temprature = temprature;
    }

    public List<Description> getWeather() {
        return weather;
    }

    public void setWeather(List<Description> weather) {
        this.weather = weather;
    }
    public float getDt() {
        return dt;
    }


    public float getPressure() {
        return pressure;
    }


    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }



    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }


    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

}
