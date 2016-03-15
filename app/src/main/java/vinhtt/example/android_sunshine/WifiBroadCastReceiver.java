package vinhtt.example.android_sunshine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class WifiBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "WifiBroadCastReceiver", Toast.LENGTH_SHORT).show();
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        final int extraWifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE , WifiManager.WIFI_STATE_UNKNOWN);
        switch (extraWifiState) {
            case WifiManager.WIFI_STATE_DISABLED:
                Toast.makeText(context, "Manifest WIFI STATE DISABLED", Toast.LENGTH_SHORT).show();
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                Toast.makeText(context, "Manifest WIFI STATE ENABLED", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
