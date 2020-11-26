// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.ui.fragments.home.di;

import com.developer.smmmousavi.balefilm.repository.GenreRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class HomeFragmentModule_ProvideGenreRepositoryFactory
    implements Factory<GenreRepository> {
  private final HomeFragmentModule module;

  public HomeFragmentModule_ProvideGenreRepositoryFactory(HomeFragmentModule module) {
    this.module = module;
  }

  @Override
  public GenreRepository get() {
    return provideGenreRepository(module);
  }

  public static HomeFragmentModule_ProvideGenreRepositoryFactory create(HomeFragmentModule module) {
    return new HomeFragmentModule_ProvideGenreRepositoryFactory(module);
  }

  public static GenreRepository provideGenreRepository(HomeFragmentModule instance) {
    return Preconditions.checkNotNull(
        instance.provideGenreRepository(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
