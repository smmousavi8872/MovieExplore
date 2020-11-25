// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.factory.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class ViewModelProviderFactory_Factory implements Factory<ViewModelProviderFactory> {
  private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider;

  public ViewModelProviderFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    this.creatorsProvider = creatorsProvider;
  }

  @Override
  public ViewModelProviderFactory get() {
    return new ViewModelProviderFactory(creatorsProvider.get());
  }

  public static ViewModelProviderFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> creatorsProvider) {
    return new ViewModelProviderFactory_Factory(creatorsProvider);
  }

  public static ViewModelProviderFactory newInstance(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
    return new ViewModelProviderFactory(creators);
  }
}
