package com.developer.smmmousavi.balefilm.ui.fragments.detail.di;

import com.developer.smmmousavi.balefilm.factory.viewmodel.di.ViewModelKey;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.DetailFragmentViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class DetailFragmentVMModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailFragmentViewModel.class)
    public abstract ViewModel bindDetailFragmentViewModel(DetailFragmentViewModel viewModel);
}
