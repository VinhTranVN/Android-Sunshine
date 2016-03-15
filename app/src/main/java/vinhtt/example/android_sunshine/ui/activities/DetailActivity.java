package vinhtt.example.android_sunshine.ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import vinhtt.example.android_sunshine.R;
import vinhtt.example.android_sunshine.ui.fragments.DetailActivityFragment;

public class DetailActivity extends AppCompatActivity {

    private ShareActionProvider mShareActionProvider;
    private String mIntentData;

    private BroadcastReceiver mMyBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final int extraWifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE , WifiManager.WIFI_STATE_UNKNOWN);
            switch (extraWifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    Toast.makeText(DetailActivity.this, "WIFI STATE DISABLED", Toast.LENGTH_SHORT).show();
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    Toast.makeText(DetailActivity.this, "WIFI STATE ENABLED", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get data passed from MainScreen
        mIntentData = getIntent().getStringExtra("DATA");

        DetailActivityFragment fragment = (DetailActivityFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        fragment.updateData(mIntentData);

        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(mMyBroadCastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyBroadCastReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu_detail, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider)  MenuItemCompat.getActionProvider(item);

        setShareIntent(initSendMessageIntent());

        // Return true to display menu
        return true;
    }

    private Intent initSendMessageIntent(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, mIntentData);
        sendIntent.setType("text/plain");
        return sendIntent;
    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }
}
