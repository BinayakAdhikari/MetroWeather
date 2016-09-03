package com.blaze.metroweather.RecyclerViewClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blaze.metroweather.R;

import org.w3c.dom.Text;

/**
 * Created by blaze on 9/3/16.
 */
public class FutureForecastViewHolder extends RecyclerView.ViewHolder{

    public TextView icon;
    public TextView day;
    public TextView status;
    public TextView minTemp;
    public TextView maxTemp;


    public FutureForecastViewHolder(View itemView) {
        super(itemView);

        icon =  (TextView) itemView.findViewById(R.id.weathericon);
        day = (TextView)itemView.findViewById(R.id.txtday);
        status = (TextView)itemView.findViewById(R.id.txtstatus);
        minTemp = (TextView)itemView.findViewById(R.id.txtmintemp);
        maxTemp=(TextView)itemView.findViewById(R.id.txtmaxtemp);


    }
}
