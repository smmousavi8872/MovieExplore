package com.developer.smmmousavi.balefilm.ui.activities.base;

import com.developer.smmmousavi.balefilm.ui.activities.drawer.BaseDrawerActivity;
import com.developer.smmmousavi.balefilm.ui.activities.main.MainActivity;
import com.developer.smmmousavi.balefilm.ui.activities.singlefragment.SingleFragmentActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract BaseDaggerCompatActivity contributeBaseDaggerCompatActivity();

    @ContributesAndroidInjector
    abstract BaseDrawerActivity contributeBaseDrawerActivity();

    @ContributesAndroidInjector
    abstract SingleFragmentActivity contributeSingleFragmentActivity();

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

}