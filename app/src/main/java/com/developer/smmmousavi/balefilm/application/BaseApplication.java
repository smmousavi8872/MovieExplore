package com.developer.smmmousavi.balefilm.application;


import android.content.Context;

import com.developer.smmmousavi.balefilm.application.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    private static volatile Context sApplicationContext;

    public static Context getAppContext() {
        return sApplicationContext;
    }

    @Override
    public void onCreate() {
        try {
            sApplicationContext = getApplicationContext();
        } catch (Throwable ignore) {

        }
        super.onCreate();
        if (sApplicationContext == null) {
            sApplicationContext = getApplicationContext();
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }


}
