package com.developer.smmmousavi.balefilm.ui.fragments.detail.di;

import com.developer.smmmousavi.balefilm.repository.MoviesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailFragmentModule {

    @Provides
    public MoviesRepository provideMovieRepository() {
        return MoviesRepository.getInstance();
    }
}
