package com.blaze.metroweather;

import com.blaze.metroweather.RestAPI.ModelPoJo.WeatherPoJo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by blaze on 9/2/16.
 */
public interface WeatherInterface {

    @GET("{APIKEY}/{LATITUDE},{LONGITUDE}")
    Call<WeatherPoJo> getWeatherInfo(@Path("APIKEY") String api_key,
                                     @Path("LATITUDE") Double latitude,
                                     @Path("LONGITUDE") Double longitude);

}
