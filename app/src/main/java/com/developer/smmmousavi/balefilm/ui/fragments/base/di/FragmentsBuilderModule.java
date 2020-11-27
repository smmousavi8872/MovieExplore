package com.developer.smmmousavi.balefilm.ui.fragments.base.di;

import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.DetailFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.di.DetailFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.di.DetailFragmentVMModule;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentVMModule;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentVMModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class,})
    abstract BaseDaggerFragment contributeBaseDaggerFragment();

    @ContributesAndroidInjector(modules = {HomeFragmentModule.class, HomeFragmentVMModule.class,})
    abstract HomeFragment contributeHomeDaggerFragment();

    @ContributesAndroidInjector(modules = {SearchFragmentModule.class, SearchFragmentVMModule.class,})
    abstract SearchFragment contributeSearchFragment();

    @ContributesAndroidInjector(modules = {DetailFragmentModule.class, DetailFragmentVMModule.class,})
    abstract DetailFragment contributeDetailFragment();





}
