package com.developer.smmmousavi.balefilm.activities.base;

import com.developer.smmmousavi.balefilm.activities.drawer.BaseDrawerActivity;
import com.developer.smmmousavi.balefilm.activities.main.MainActivity;
import com.developer.smmmousavi.balefilm.activities.singlefragment.SingleFragmentActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract BaseDaggerCompatActivity contributeBaseDaggerCompatActivity();

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract BaseDrawerActivity contributeBaseDrawerActivity();

    @ContributesAndroidInjector
    abstract SingleFragmentActivity contributeSingleFragmentActivity();
}
