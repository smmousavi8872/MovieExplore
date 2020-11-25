package com.developer.smmmousavi.balefilm.fragments.setting.di;

import com.developer.smmmousavi.balefilm.factory.viewmodel.di.ViewModelKey;
import com.developer.smmmousavi.balefilm.fragments.setting.SettingFragmentViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class SettingFragmentVMModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingFragmentViewModel.class)
    public abstract ViewModel bindSettingFragmentViewModel(SettingFragmentViewModel viewModel);

}
