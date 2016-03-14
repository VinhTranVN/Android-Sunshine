package vinhtt.example.android_sunshine.services.impl;

import vinhtt.example.android_sunshine.services.ServiceFactory;
import vinhtt.example.android_sunshine.services.WeatherService;

/**
 * Created by VinhTT on 14-Mar-16.
 */
public class DefaultServiceFactory implements ServiceFactory {

    private WeatherService mWeatherService;
    public DefaultServiceFactory() {
        mWeatherService = new YahooWeatherServiceImpl();
    }

    @Override
    public WeatherService getWeatherService() {
        return mWeatherService;
    }
}
