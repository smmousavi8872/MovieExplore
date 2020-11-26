// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.ui.fragments.home;

import androidx.fragment.app.Fragment;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<ViewModelProviderFactory> mProviderFactoryProvider;

  private final Provider<RecyclerViewHelper> mRvHelperProvider;

  public HomeFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<ViewModelProviderFactory> mProviderFactoryProvider,
      Provider<RecyclerViewHelper> mRvHelperProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mProviderFactoryProvider = mProviderFactoryProvider;
    this.mRvHelperProvider = mRvHelperProvider;
  }

  public static MembersInjector<HomeFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<ViewModelProviderFactory> mProviderFactoryProvider,
      Provider<RecyclerViewHelper> mRvHelperProvider) {
    return new HomeFragment_MembersInjector(
        childFragmentInjectorProvider, mProviderFactoryProvider, mRvHelperProvider);
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    injectMProviderFactory(instance, mProviderFactoryProvider.get());
    injectMRvHelper(instance, mRvHelperProvider.get());
  }

  public static void injectMProviderFactory(
      HomeFragment instance, ViewModelProviderFactory mProviderFactory) {
    instance.mProviderFactory = mProviderFactory;
  }

  public static void injectMRvHelper(HomeFragment instance, RecyclerViewHelper mRvHelper) {
    instance.mRvHelper = mRvHelper;
  }
}
