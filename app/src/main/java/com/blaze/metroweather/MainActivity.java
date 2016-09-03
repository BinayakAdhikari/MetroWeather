package com.blaze.metroweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blaze.metroweather.RecyclerViewClasses.FutureForecastAdapter;
import com.blaze.metroweather.RecyclerViewClasses.FutureForecastObject;
import com.blaze.metroweather.RestAPI.ModelPoJo.WeatherPoJo;
import com.blaze.metroweather.RestAPI.Service.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Double Latitude;
    private Double Longitude;
    private LocationTracker locationTracker;
    private TextView location, status, temp;
    private RecyclerView recyclerView;
    private ArrayList<WeatherPoJo> poJoArrayList = new ArrayList<>();
    private FutureForecastAdapter forecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = (TextView) findViewById(R.id.txtlocation);
        status = (TextView) findViewById(R.id.txtstatus);
        temp = (TextView) findViewById(R.id.txttemp);

        recyclerView = (RecyclerView) findViewById(R.id.forecast);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        forecastAdapter = new FutureForecastAdapter(MainActivity.this,poJoArrayList);
        recyclerView.setAdapter(forecastAdapter);


        setLocationTracker();

        getWeatherDetails();

    }

    public void getWeatherDetails() {

        RetrofitManager retrofitManager = null;
        retrofitManager = RetrofitManager.getInstance();
        retrofitManager.getWeatherInfo("33e2e2283aa4a23313a10d21a3ecd1a1", Latitude, Longitude,
                new Callback<WeatherPoJo>() {
                    @Override
                    public void onResponse(Call<WeatherPoJo> call, Response<WeatherPoJo> response) {
                        if (response.code() == 200) {
                            location.setText(response.body().getTimezone());
                            status.setText(response.body().getCurrently().getSummary());
                            temp.setText(String.valueOf(response.body().getCurrently().getApparentTemperature()));
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherPoJo> call, Throwable t) {

                        Log.i("FAILEDDD", "onFailure: " + t.getLocalizedMessage());

                    }
                });
    }

    public void setLocationTracker() {

        locationTracker = new LocationTracker(MainActivity.this);
        if (locationTracker.isGPSEnabled) {

            Latitude = locationTracker.getLatitude();
            Longitude = locationTracker.getLongitude();
        } else {
            locationTracker.showSettingsAlert();
        }
    }
}
