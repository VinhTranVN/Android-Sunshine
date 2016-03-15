package vinhtt.example.android_sunshine.data.impl;

import com.google.gson.Gson;

import vinhtt.example.android_sunshine.data.WeatherRepository;
import vinhtt.example.android_sunshine.model.WeatherInfo;

/**
 * Created by VinhTT on 14-Mar-16.
 */
public class YahooWeatherRepositoryImpl implements WeatherRepository {
    private static final String WS_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22tphcm%2C%20VN%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
    @Override
    public WeatherInfo getWeatherInfo() {
        // TODO get weather info
        /*try {
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
        return null;
        */

        Gson gson = new Gson();
        String json = "{\"forecast\":[{\"code\":\"29\",\"date\":\"15 Mar 2016\",\"day\":\"Tue\",\"high\":\"92\",\"low\":\"77\",\"text\":\"Partly Cloudy\"},{\"code\":\"30\",\"date\":\"16 Mar 2016\",\"day\":\"Wed\",\"high\":\"95\",\"low\":\"77\",\"text\":\"Partly Cloudy\"},{\"code\":\"30\",\"date\":\"17 Mar 2016\",\"day\":\"Thu\",\"high\":\"91\",\"low\":\"76\",\"text\":\"Partly Cloudy\"},{\"code\":\"30\",\"date\":\"18 Mar 2016\",\"day\":\"Fri\",\"high\":\"92\",\"low\":\"75\",\"text\":\"Partly Cloudy\"},{\"code\":\"34\",\"date\":\"19 Mar 2016\",\"day\":\"Sat\",\"high\":\"95\",\"low\":\"76\",\"text\":\"Mostly Sunny\"}]}";
        WeatherInfo weatherInfo = gson.fromJson(json, WeatherInfo.class);

        return  weatherInfo;
    }
}
