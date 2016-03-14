package vinhtt.example.android_sunshine.data.impl;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import vinhtt.example.android_sunshine.data.WeatherRepository;
import vinhtt.example.android_sunshine.model.WeatherInfo;
import vinhtt.example.android_sunshine.utils.HttpRequestUtil;

/**
 * Created by VinhTT on 14-Mar-16.
 */
public class YahooWeatherRepositoryImpl implements WeatherRepository {
    private static final String WS_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22tphcm%2C%20VN%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
    @Override
    public WeatherInfo getWeatherInfo() {
        // TODO get weather info
        try {
            String dataResponse = HttpRequestUtil.makeRequest(WS_URL);
            JSONObject jsonObject = new JSONObject(dataResponse);
            JSONObject item = jsonObject.getJSONObject("query")
                    .getJSONObject("results")
                    .getJSONObject("channel")
                    .getJSONObject("item");
            //JSONArray forecast = item.getJSONArray("forecast");
            Log.d("TEST", "VTT>>> item.toString() " + item.toString());
            Gson gson = new Gson();
            WeatherInfo weatherInfo = gson.fromJson(item.toString(), WeatherInfo.class);
            return weatherInfo;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
