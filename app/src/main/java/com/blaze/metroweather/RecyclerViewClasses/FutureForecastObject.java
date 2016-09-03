package com.blaze.metroweather.RecyclerViewClasses;

/**
 * Created by blaze on 9/3/16.
 */
public class FutureForecastObject {

    private String day;
    private String status;
    private String minTemp;
    private String maxTemp;
    private int icon;

    public FutureForecastObject(String day, int icon, String minTemp, String status, String maxTemp) {
        this.day = day;
        this.icon = icon;
        this.minTemp = minTemp;
        this.status = status;
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {

        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
