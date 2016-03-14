package vinhtt.example.android_sunshine.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VinhTT on 14-Mar-16.
 */
public class WeatherInfo {
    @SerializedName("forecast")
    private List<Forecast> forecast = new ArrayList<Forecast>();

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
