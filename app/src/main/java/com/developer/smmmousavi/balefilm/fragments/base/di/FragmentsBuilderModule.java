package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.base.BaseDaggerFrgment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class,})
    abstract BaseDaggerFrgment contributeBaseDaggerFragment();

}
