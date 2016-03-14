package vinhtt.example.android_sunshine.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import vinhtt.example.android_sunshine.MyApplication;
import vinhtt.example.android_sunshine.R;
import vinhtt.example.android_sunshine.model.WeatherInfo;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get ListView object from xml
        ListView listView = (ListView) view.findViewById(R.id.listView);

        // Defined Array weathers to show in ListView
        String[] weathers = new String[] {
                "Today - Sunny - 88/63",
                "Tomorrow - Sunny - 88/63",
                "Thu - Sunny - 88/63",
                "Fri - Sunny - 88/63",
                "Sat - Sunny - 88/63",
                "Sun - Sunny - 88/63"
        };

        new AsyncTask<Void, Void, WeatherInfo>(){
            @Override
            protected WeatherInfo doInBackground(Void... params) {
                return MyApplication.getServiceFactory().getWeatherService().getWeatherInfo();
            }

            @Override
            protected void onPostExecute(WeatherInfo weatherInfo) {
                Log.d("TEST", "VTT>>> weatherInfo " + weatherInfo);
                if (weatherInfo != null){
                    Log.d("TEST", "VTT>>> weatherInfo : " + weatherInfo.getForecast().toString());

                }
            }
        }.execute();



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, weathers);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
    }
}
