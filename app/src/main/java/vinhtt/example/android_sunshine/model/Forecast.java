package vinhtt.example.android_sunshine.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by VinhTT on 15-Mar-16.
 */
public class Forecast {

    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("day")
    @Expose
    public String day;
    @SerializedName("high")
    @Expose
    public String high;
    @SerializedName("low")
    @Expose
    public String low;
    @SerializedName("text")
    @Expose
    public String text;

}
