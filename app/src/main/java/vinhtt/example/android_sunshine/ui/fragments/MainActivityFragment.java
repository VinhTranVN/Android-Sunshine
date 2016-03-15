package vinhtt.example.android_sunshine.ui.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vinhtt.example.android_sunshine.MyApplication;
import vinhtt.example.android_sunshine.R;
import vinhtt.example.android_sunshine.model.Forecast;
import vinhtt.example.android_sunshine.model.WeatherInfo;
import vinhtt.example.android_sunshine.ui.activities.DetailActivity;
import vinhtt.example.android_sunshine.ui.adapters.ItemForecastAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar mProgressBar;
    private ListView mListView;
    private List<Forecast> mForecastList = new ArrayList<>();
    private ItemForecastAdapter mAdapter;

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

        mAdapter = new ItemForecastAdapter(getActivity(), mForecastList);
        mListView.setAdapter(mAdapter);

        // handle item click on listview
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Forecast forecast = mForecastList.get(position);
                Toast.makeText(getActivity(), forecast.toString(), Toast.LENGTH_SHORT).show();
                // Explicit intent : start DetailActivity
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("DATA", forecast.toString());
                startActivity(intent);
            }
        });

        loadData();
    }

    private void loadData() {
        // Defined Array weathers to show in ListView
        new AsyncTask<Void, Void, WeatherInfo>() {
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
                mProgressBar.setVisibility(View.GONE);
                if (weatherInfo != null) {
                    mForecastList.clear();
                    mForecastList.addAll(weatherInfo.getForecast());
                    mAdapter.notifyDataSetChanged(); // update data on listview
                }
            }
        }.execute();
    }
}
