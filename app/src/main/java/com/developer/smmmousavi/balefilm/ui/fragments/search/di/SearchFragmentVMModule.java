package com.developer.smmmousavi.balefilm.ui.fragments.search.di;

import com.developer.smmmousavi.balefilm.factory.viewmodel.di.ViewModelKey;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragmentViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class SearchFragmentVMModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchFragmentViewModel.class)
    public abstract ViewModel bindSearchFragmentViewModel(SearchFragmentViewModel viewModel);

}
