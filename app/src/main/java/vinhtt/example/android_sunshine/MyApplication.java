package vinhtt.example.android_sunshine;

import android.app.Application;

import vinhtt.example.android_sunshine.services.ServiceFactory;
import vinhtt.example.android_sunshine.services.impl.DefaultServiceFactory;

/**
 * Created by VinhTT on 15-Mar-16.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;
    private ServiceFactory mServiceFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mServiceFactory = new DefaultServiceFactory();
    }

    public static ServiceFactory getServiceFactory() {
        return sInstance.mServiceFactory;
    }
}
