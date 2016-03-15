package vinhtt.example.android_sunshine.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import vinhtt.example.android_sunshine.R;
import vinhtt.example.android_sunshine.ui.fragments.DetailActivityFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get data passed from MainScreen
        String intentData = getIntent().getStringExtra("DATA");

        DetailActivityFragment fragment = (DetailActivityFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        fragment.updateData(intentData);
    }

}
