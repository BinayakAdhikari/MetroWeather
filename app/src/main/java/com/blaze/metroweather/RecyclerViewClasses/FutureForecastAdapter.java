package com.blaze.metroweather.RecyclerViewClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blaze.metroweather.MainActivity;
import com.blaze.metroweather.R;
import com.blaze.metroweather.RestAPI.ModelPoJo.Datum_;
import com.blaze.metroweather.RestAPI.ModelPoJo.WeatherPoJo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by blaze on 9/3/16.
 */
public class FutureForecastAdapter extends RecyclerView.Adapter<FutureForecastViewHolder> {
    private ArrayList<WeatherPoJo> weatherPoJoArrayList;
    private ArrayList<Datum_> daily;
    private Double minTemp;
    private Double maxTemp;
    private Context context;

    public FutureForecastAdapter(Context context, ArrayList<WeatherPoJo> weatherPoJoArrayList) {
        this.weatherPoJoArrayList = weatherPoJoArrayList;
        this.context = context;
    }


    @Override
    public FutureForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.futureforecast,null);
        FutureForecastViewHolder forecastViewHolder = new FutureForecastViewHolder(view);
        return forecastViewHolder;
    }

    @Override
    public void onBindViewHolder(FutureForecastViewHolder holder, int position) {
        maxTemp = daily.get(position).getApparentTemperatureMax();
        minTemp = daily.get(position).getTemperatureMin();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        holder.day.setText(day);
        holder.status.setText(weatherPoJoArrayList.get(position).getDaily().getSummary());
        holder.icon.setText(weatherPoJoArrayList.get(position).getDaily().getIcon());
        holder.maxTemp.setText(String.valueOf(maxTemp));
        holder.minTemp.setText(String.valueOf(minTemp));

    }

    @Override
    public int getItemCount() {
        return weatherPoJoArrayList.size();
    }
}
