package com.developer.smmmousavi.balefilm.fragments.setting;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class SettingFragmentViewModel extends BaseViewModel {

    @Inject
    public SettingFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
