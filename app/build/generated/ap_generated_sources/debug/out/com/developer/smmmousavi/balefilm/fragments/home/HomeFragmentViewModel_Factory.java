// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.fragments.home;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HomeFragmentViewModel_Factory implements Factory<HomeFragmentViewModel> {
  private final Provider<Application> applicationProvider;

  public HomeFragmentViewModel_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public HomeFragmentViewModel get() {
    return new HomeFragmentViewModel(applicationProvider.get());
  }

  public static HomeFragmentViewModel_Factory create(Provider<Application> applicationProvider) {
    return new HomeFragmentViewModel_Factory(applicationProvider);
  }

  public static HomeFragmentViewModel newInstance(Application application) {
    return new HomeFragmentViewModel(application);
  }
}
