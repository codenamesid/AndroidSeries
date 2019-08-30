package com.codenamesid.applicationseries.openweathermvp;

import com.codenamesid.applicationseries.openweathermvp.data.Forecast;

import io.reactivex.Single;


public interface WeatherContract {

    interface WeatherView{
        void showProgressBar();

        void hideProgressBar();

        void setWeatherData(Forecast weatherData);
    }
    interface WeatherModel{
        interface OnWeatherDataReadyListener{
            void onDataReady(Forecast data);
        }
        Single<Forecast> getWeatherData(String zip);
    }
    interface WeatherPresenter{
        void onSearchClick(String zip);
        void onDestroy();
    }
}
