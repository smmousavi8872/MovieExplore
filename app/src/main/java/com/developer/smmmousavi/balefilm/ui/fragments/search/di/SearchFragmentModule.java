package com.developer.smmmousavi.balefilm.ui.fragments.search.di;

import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.repository.SearchMovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchFragmentModule {

    @Provides
    public SearchMovieRepository provideSearchMovieRepository() {
        return SearchMovieRepository.getInstance();
    }

    @Provides
    public RecyclerViewHelper provideRecyclerViewHelper() {
        return new RecyclerViewHelper();
    }
}
