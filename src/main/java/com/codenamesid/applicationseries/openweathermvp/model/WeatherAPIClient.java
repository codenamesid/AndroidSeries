package com.codenamesid.applicationseries.openweathermvp.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                                                .addInterceptor(new APIKeyInterceptor())
                                                .addInterceptor(interceptor)
                                                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }
    static class APIKeyInterceptor implements Interceptor{
        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request originalReq=chain.request();
            HttpUrl originalUrl=originalReq.url();

            HttpUrl newUrl=originalUrl.newBuilder()
                            .addQueryParameter("APPID","129d49636dd3da9790f2371d2ab11ca0")
                            .build();

            Request.Builder requestBuilder=originalReq.newBuilder()
                                                .url(newUrl);
            return chain.proceed(requestBuilder.build());
        }
    }

}
