package com.blaze.metroweather.RestAPI.Service;

import com.blaze.metroweather.BuildConfig;
import com.blaze.metroweather.RestAPI.ModelPoJo.WeatherPoJo;
import com.blaze.metroweather.WeatherInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by blaze on 9/2/16.
 */
public class RetrofitManager  {
    public static Retrofit retrofit = null;
    public  static WeatherInterface weatherInterface = null;
    public static RetrofitManager retrofitManager = null;

    private RetrofitManager(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        weatherInterface = retrofit.create(WeatherInterface.class);
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }

        return retrofitManager;

    }

    public void getWeatherInfo
            (String api_key,Double latitude, Double longitude, Callback<WeatherPoJo> weatherPoJoCallback){
        Call<WeatherPoJo> weatherPoJoCall = weatherInterface.getWeatherInfo(api_key,latitude,longitude);
        weatherPoJoCall.enqueue(weatherPoJoCallback);

    }
}
