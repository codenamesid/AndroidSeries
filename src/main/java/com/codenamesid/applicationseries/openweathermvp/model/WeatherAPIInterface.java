package com.codenamesid.applicationseries.openweathermvp.model;

import com.codenamesid.applicationseries.openweathermvp.data.Forecast;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPIInterface {

    // api.openweathermap.org/data/2.5/forecast/daily?zip=94040,us

    @GET("/data/2.5/forecast?")
    //api.openweathermap.org/data/2.5/forecast?zip=94040,us
    Single<Forecast> getForecastByZip(@Query("zip") String zip);
}
