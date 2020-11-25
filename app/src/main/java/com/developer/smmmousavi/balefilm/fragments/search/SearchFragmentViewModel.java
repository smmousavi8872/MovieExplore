package com.developer.smmmousavi.balefilm.fragments.search;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class SearchFragmentViewModel extends BaseViewModel {

    @Inject
    public SearchFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
