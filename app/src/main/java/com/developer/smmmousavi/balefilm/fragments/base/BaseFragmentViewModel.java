package com.developer.smmmousavi.balefilm.fragments.base;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;

import javax.inject.Inject;

public class BaseFragmentViewModel extends BaseViewModel {

    @Inject
    public BaseFragmentViewModel(Application application) {
        super(application);
    }
}
