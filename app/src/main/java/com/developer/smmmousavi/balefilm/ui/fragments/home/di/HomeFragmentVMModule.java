package com.developer.smmmousavi.balefilm.ui.fragments.home.di;

import com.developer.smmmousavi.balefilm.factory.viewmodel.di.ViewModelKey;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragmentViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class HomeFragmentVMModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel.class)
    public abstract ViewModel bindHomeFragmentViewModel(HomeFragmentViewModel viewModel);



}
