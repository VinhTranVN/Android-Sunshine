package vinhtt.example.android_sunshine.services.impl;

import vinhtt.example.android_sunshine.data.WeatherRepository;
import vinhtt.example.android_sunshine.data.impl.YahooWeatherRepositoryImpl;
import vinhtt.example.android_sunshine.model.WeatherInfo;
import vinhtt.example.android_sunshine.services.WeatherService;

/**
 * Created by VinhTT on 14-Mar-16.
 */
public class YahooWeatherServiceImpl implements WeatherService {
    private WeatherRepository mWeatherRepository;
    public YahooWeatherServiceImpl() {
        mWeatherRepository = new YahooWeatherRepositoryImpl();
    }

    @Override
    public WeatherInfo getWeatherInfo() {
        return mWeatherRepository.getWeatherInfo();
    }
}
