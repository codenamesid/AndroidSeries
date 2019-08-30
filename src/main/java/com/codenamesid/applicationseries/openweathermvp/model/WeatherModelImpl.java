package com.codenamesid.applicationseries.openweathermvp.model;

import com.codenamesid.applicationseries.openweathermvp.WeatherContract;
import com.codenamesid.applicationseries.openweathermvp.data.Forecast;

import io.reactivex.Single;


public class WeatherModelImpl implements WeatherContract.WeatherModel {

    WeatherAPIInterface modelInterface;

    public WeatherModelImpl(){
        modelInterface=WeatherAPIClient.getClient().create(WeatherAPIInterface.class);
    }
    @Override
    public Single<Forecast> getWeatherData(String zip) {
        return modelInterface.getForecastByZip(zip);

    }
}
