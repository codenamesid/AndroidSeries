package com.codenamesid.applicationseries.openweathermvp.data;

import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("temp")
    private float temp;

    @SerializedName("temp_min")
    private float min;

    @SerializedName("temp_max")
    private float max;

    @SerializedName("pressure")
    private float presure;

    @SerializedName("humidity")
    private float humidity;


    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPresure() {
        return presure;
    }

    public void setPresure(float presure) {
        this.presure = presure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }


    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
    }

}
