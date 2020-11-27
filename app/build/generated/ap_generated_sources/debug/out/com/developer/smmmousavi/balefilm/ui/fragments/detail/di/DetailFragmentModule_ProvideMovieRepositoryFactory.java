// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.ui.fragments.detail.di;

import com.developer.smmmousavi.balefilm.repository.MoviesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DetailFragmentModule_ProvideMovieRepositoryFactory
    implements Factory<MoviesRepository> {
  private final DetailFragmentModule module;

  public DetailFragmentModule_ProvideMovieRepositoryFactory(DetailFragmentModule module) {
    this.module = module;
  }

  @Override
  public MoviesRepository get() {
    return provideMovieRepository(module);
  }

  public static DetailFragmentModule_ProvideMovieRepositoryFactory create(
      DetailFragmentModule module) {
    return new DetailFragmentModule_ProvideMovieRepositoryFactory(module);
  }

  public static MoviesRepository provideMovieRepository(DetailFragmentModule instance) {
    return Preconditions.checkNotNull(
        instance.provideMovieRepository(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}