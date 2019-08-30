package com.codenamesid.applicationseries.openweathermvp.data;

import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("id")
    private float id;

    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public float getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return "http://openweathermap.org/img/wn/"+icon+"@2x.png";
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
