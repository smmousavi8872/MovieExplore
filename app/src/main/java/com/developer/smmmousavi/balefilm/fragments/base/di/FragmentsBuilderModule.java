package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.fragments.home.di.HomeFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.home.di.HomeFragmentVMModule;
import com.developer.smmmousavi.balefilm.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.fragments.search.di.SearchFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.search.di.SearchFragmentVMModule;
import com.developer.smmmousavi.balefilm.fragments.setting.SettingFragment;
import com.developer.smmmousavi.balefilm.fragments.setting.di.SettingFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.setting.di.SettingFragmentVMModule;

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

    @ContributesAndroidInjector(modules = {SettingFragmentModule.class, SettingFragmentVMModule.class,})
    abstract SettingFragment contributeSettingDaggerFragment();




}
