package com.developer.smmmousavi.balefilm.ui.fragments.home.di;

import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.repository.GenreRepository;
import com.developer.smmmousavi.balefilm.repository.MovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    @Provides
    public MovieRepository provideMovieRepository() {
        return MovieRepository.getInstance();
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
