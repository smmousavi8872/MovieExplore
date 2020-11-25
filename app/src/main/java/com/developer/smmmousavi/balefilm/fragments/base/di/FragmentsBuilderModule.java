package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.fragments.home.di.HomeFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.home.di.HomeFragmentVMModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class,})
    abstract BaseDaggerFragment contributeBaseDaggerFragment();

    @ContributesAndroidInjector(modules = {HomeFragmentModule.class, HomeFragmentVMModule.class,})
    abstract HomeFragment contributeHomeDaggerFragment();


}
