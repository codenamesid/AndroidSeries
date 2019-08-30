package com.codenamesid.applicationseries.openweathermvp.data;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    private float id;

    @SerializedName("name")
    private String name;

    @SerializedName("coordObject")
    Coord coordObject;

    @SerializedName("country")
    private String country;

    @SerializedName("population")
    private float population;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coordObject;
    }

    public String getCountry() {
        return country;
    }

    public float getPopulation() {
        return population;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coordObject) {
        this.coordObject = coordObject;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(float population) {
        this.population = population;
    }
}
