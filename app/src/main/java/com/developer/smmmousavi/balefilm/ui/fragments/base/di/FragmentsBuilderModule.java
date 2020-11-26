package com.developer.smmmousavi.balefilm.ui.fragments.base.di;

import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentVMModule;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentVMModule;
import com.developer.smmmousavi.balefilm.ui.fragments.setting.SettingFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.setting.di.SettingFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.setting.di.SettingFragmentVMModule;

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
