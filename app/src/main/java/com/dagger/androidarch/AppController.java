package com.dagger.androidarch;

import android.app.Application;
import android.content.Context;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class AppController extends Application {

    private volatile static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static   Context getAppContext() {
        return context;
    }
}
