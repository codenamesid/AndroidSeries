package com.codenamesid.applicationseries.openweathermvp.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Forecast {

    @SerializedName("city")
    City city;

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private float message;

    @SerializedName("cnt")
    private float cnt;

    @SerializedName("list")
    List< Weather > list = new ArrayList();

    public List<Weather> getList() {
        return list;
    }

    public void setList(List<Weather> list) {
        this.list = list;
    }
    public City getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public float getCnt() {
        return cnt;
    }


    public void setCity(City cityObject) {
        this.city = cityObject;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public void setCnt(float cnt) {
        this.cnt = cnt;
    }
}

