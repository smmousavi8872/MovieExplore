package com.developer.smmmousavi.balefilm.activities.base;

import com.developer.smmmousavi.balefilm.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
