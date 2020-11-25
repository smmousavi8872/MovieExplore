package com.developer.smmmousavi.balefilm.fragments.home;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class HomeFragmentViewModel extends BaseViewModel {

    @Inject
    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}