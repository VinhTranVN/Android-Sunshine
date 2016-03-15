package vinhtt.example.android_sunshine.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import vinhtt.example.android_sunshine.MyApplication;
import vinhtt.example.android_sunshine.R;
import vinhtt.example.android_sunshine.model.Forecast;
import vinhtt.example.android_sunshine.model.WeatherInfo;
import vinhtt.example.android_sunshine.ui.adapters.ItemForecastAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar mProgressBar;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get ListView object from xml
        mListView = (ListView) view.findViewById(R.id.listView);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        // Defined Array weathers to show in ListView
        new AsyncTask<Void, Void, WeatherInfo>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected WeatherInfo doInBackground(Void... params) {
                return MyApplication.getServiceFactory().getWeatherService().getWeatherInfo();
            }

            @Override
            protected void onPostExecute(WeatherInfo weatherInfo) {
                if(getActivity() == null){
                    return;
                }

                mProgressBar.setVisibility(View.GONE);
                if (weatherInfo != null){
                    List<Forecast> forecastList = weatherInfo.getForecast();
                    ItemForecastAdapter adapter = new ItemForecastAdapter(getActivity(), forecastList);
                    // Assign adapter to ListView
                    mListView.setAdapter(adapter);
                }
            }
        }.execute();

    }
}
