package com.developer.smmmousavi.balefilm.ui.activities.base;

import com.developer.smmmousavi.balefilm.ui.activities.detail.DetailActivity;
import com.developer.smmmousavi.balefilm.ui.activities.detail.di.DetailActivityModule;
import com.developer.smmmousavi.balefilm.ui.activities.drawer.BaseDrawerActivity;
import com.developer.smmmousavi.balefilm.ui.activities.drawer.di.BaseDrawerActivityModule;
import com.developer.smmmousavi.balefilm.ui.activities.main.MainActivity;
import com.developer.smmmousavi.balefilm.ui.activities.main.di.MainActivityModule;
import com.developer.smmmousavi.balefilm.ui.activities.singlefragment.SingleFragmentActivity;
import com.developer.smmmousavi.balefilm.ui.activities.singlefragment.di.SingleFragmentActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector()
    abstract BaseDaggerCompatActivity contributeBaseDaggerCompatActivity();

    @ContributesAndroidInjector(modules = {BaseDrawerActivityModule.class})
    abstract BaseDrawerActivity contributeBaseDrawerActivity();

    @ContributesAndroidInjector(modules = {SingleFragmentActivityModule.class})
    abstract SingleFragmentActivity contributeSingleFragmentActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {DetailActivityModule.class})
    abstract DetailActivity contributeDetailActivity();

}
