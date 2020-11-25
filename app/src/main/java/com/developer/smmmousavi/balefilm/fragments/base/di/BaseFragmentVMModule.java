package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.factory.viewmodel.di.ViewModelKey;
import com.developer.smmmousavi.balefilm.fragments.base.BaseFragmentViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class BaseFragmentVMModule {

    @Binds
    @IntoMap
    @ViewModelKey(BaseFragmentViewModel.class)
    public abstract ViewModel bindBaseFragmentViewModel(BaseFragmentViewModel viewModel);

}
