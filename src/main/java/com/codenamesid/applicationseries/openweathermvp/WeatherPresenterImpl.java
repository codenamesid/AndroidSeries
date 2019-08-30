package com.codenamesid.applicationseries.openweathermvp;

import android.util.Log;

import com.codenamesid.applicationseries.openweathermvp.data.Forecast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherPresenterImpl implements WeatherContract.WeatherPresenter, WeatherContract.WeatherModel.OnWeatherDataReadyListener {

    private static final String TAG ="WeatherPresenterImpl" ;
    WeatherContract.WeatherModel model;
    WeatherContract.WeatherView view;

    WeatherPresenterImpl(WeatherContract.WeatherModel model, WeatherContract.WeatherView view){
        this.model=model;
        this.view=view;
    }

    @Override
    public void onSearchClick(String zip) {
        view.showProgressBar();
        model.getWeatherData(zip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(forecast->{
                        onDataReady(forecast);
                    },er->{
                         Log.i(TAG,"Error in getting Data",er);
                    }
                 );
    }

    @Override
    public void onDestroy() {
        model=null;
        view=null;
    }

    @Override
    public void onDataReady(Forecast data) {
        view.setWeatherData(data);
        view.hideProgressBar();
    }
}
