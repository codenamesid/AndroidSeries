package com.codenamesid.applicationseries.openweathermvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codenamesid.applicationseries.openweathermvp.data.Forecast;
import com.codenamesid.applicationseries.openweathermvp.data.Weather;
import com.codenamesid.applicationseries.openweathermvp.model.WeatherModelImpl;

import java.util.List;

public class WeatherMain extends AppCompatActivity implements WeatherContract.WeatherView{

    WeatherContract.WeatherPresenter presenter;
    ProgressBar loading;
    RecyclerView weatherListView;
    WeatherRecyclerAdapter adapter;

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);
        editText=findViewById(R.id.editText);
        loading=findViewById(R.id.progressBar);
        weatherListView=findViewById(R.id.weatherList);
        weatherListView.setLayoutManager(new LinearLayoutManager(this));
        presenter=new WeatherPresenterImpl(new WeatherModelImpl(),this);
    }

    @Override
    public void showProgressBar() {
        weatherListView.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        weatherListView.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
    }

    @Override
    public void setWeatherData(Forecast weatherData) {
     if(adapter==null){
         adapter=new WeatherRecyclerAdapter(weatherData,this);
         weatherListView.setAdapter(adapter);
     }else{
         adapter.setWeatherData(weatherData);
     }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();
        presenter=null;
    }

    public void onSearchClick(View view) {
        String country="us";
        String zip=editText.getText().toString();
        presenter.onSearchClick(zip+","+country);
    }

    private class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.WeatherViewHolder>{

        Forecast data;
        Context ctx;
        WeatherRecyclerAdapter(Forecast data, Context ctx){
            this.data=data;
            this.ctx=ctx;
        }
        @NonNull
        @Override
        public WeatherRecyclerAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(ctx).inflate(R.layout.weather_item,parent,false);
            WeatherViewHolder holder=new WeatherViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull WeatherRecyclerAdapter.WeatherViewHolder holder, int position) {
            List<Weather> list=data.getList();
            Weather w=list.get(position);
            holder.condition.setText(w.getWeather().get(0).getDescription());
            holder.minTemp.setText(w.getTemprature().getMin()+"");
            holder.maxTemp.setText(w.getTemprature().getMax()+"");
            holder.humid.setText(w.getTemprature().getHumidity()+"");
            Glide.with(ctx).load(w.getWeather().get(0).getIcon())
                    .into(holder.weatherIcon);
        }

        @Override
        public int getItemCount() {
            return data.getList().size();
        }

        public void setWeatherData(Forecast weatherData) {
            this.data=weatherData;
            notifyDataSetChanged();
        }

        class WeatherViewHolder extends RecyclerView.ViewHolder{

            public ImageView weatherIcon;
            public TextView minTemp,maxTemp,humid,condition;
            public WeatherViewHolder(@NonNull View itemView) {
                super(itemView);
                weatherIcon=itemView.findViewById(R.id.weatherIcon);
                minTemp=itemView.findViewById(R.id.minTemp);
                maxTemp=itemView.findViewById(R.id.maxTemp);
                humid=itemView.findViewById(R.id.humidity);
                condition=itemView.findViewById(R.id.weatherDisplay);
            }
        }

    }
}
