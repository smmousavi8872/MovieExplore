package com.developer.smmmousavi.balefilm.ui.fragments.home.di;

import com.developer.smmmousavi.balefilm.repository.MovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeFragmentModule {

    @Provides
    public MovieRepository provideMovieRepository() {
        return MovieRepository.getInstance();
    }
}
