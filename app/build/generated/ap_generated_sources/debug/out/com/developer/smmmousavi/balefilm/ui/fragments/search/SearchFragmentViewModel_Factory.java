// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.ui.fragments.search;

import android.app.Application;
import com.developer.smmmousavi.balefilm.repository.SearchMovieRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SearchFragmentViewModel_Factory implements Factory<SearchFragmentViewModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<SearchMovieRepository> mRepositoryProvider;

  public SearchFragmentViewModel_Factory(
      Provider<Application> applicationProvider,
      Provider<SearchMovieRepository> mRepositoryProvider) {
    this.applicationProvider = applicationProvider;
    this.mRepositoryProvider = mRepositoryProvider;
  }

  @Override
  public SearchFragmentViewModel get() {
    SearchFragmentViewModel instance = new SearchFragmentViewModel(applicationProvider.get());
    SearchFragmentViewModel_MembersInjector.injectMRepository(instance, mRepositoryProvider.get());
    return instance;
  }

  public static SearchFragmentViewModel_Factory create(
      Provider<Application> applicationProvider,
      Provider<SearchMovieRepository> mRepositoryProvider) {
    return new SearchFragmentViewModel_Factory(applicationProvider, mRepositoryProvider);
  }

  public static SearchFragmentViewModel newInstance(Application application) {
    return new SearchFragmentViewModel(application);
  }
}
