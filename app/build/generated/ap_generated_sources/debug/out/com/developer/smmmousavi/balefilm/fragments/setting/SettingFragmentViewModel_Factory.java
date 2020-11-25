// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.fragments.setting;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SettingFragmentViewModel_Factory implements Factory<SettingFragmentViewModel> {
  private final Provider<Application> applicationProvider;

  public SettingFragmentViewModel_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public SettingFragmentViewModel get() {
    return new SettingFragmentViewModel(applicationProvider.get());
  }

  public static SettingFragmentViewModel_Factory create(Provider<Application> applicationProvider) {
    return new SettingFragmentViewModel_Factory(applicationProvider);
  }

  public static SettingFragmentViewModel newInstance(Application application) {
    return new SettingFragmentViewModel(application);
  }
}
