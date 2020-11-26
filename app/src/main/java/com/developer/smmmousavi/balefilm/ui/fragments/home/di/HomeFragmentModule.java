package com.developer.smmmousavi.balefilm.ui.fragments.home.di;

import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.repository.FilteredMovieRepository;
import com.developer.smmmousavi.balefilm.repository.GenreRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    @Provides
    public FilteredMovieRepository provideMovieRepository() {
        return FilteredMovieRepository.getInstance();
    }

    @Provides
    public GenreRepository provideGenreRepository() {
        return GenreRepository.getInstance();
    }

    @Provides
    public RecyclerViewHelper provideRecyclerViewHelper() {
        return new RecyclerViewHelper();
    }
}
