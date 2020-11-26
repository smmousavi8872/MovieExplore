package com.developer.smmmousavi.balefilm.ui.fragments.search;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.repository.SearchMovieRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class SearchFragmentViewModel extends BaseViewModel {

    @Inject
    public SearchFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    @Inject
    SearchMovieRepository mRepository;

    public LiveData<List<Movie>> getSearchMoviesLd() {
        return mRepository.getSearchMovieLd();
    }

    public LiveData<Boolean> getSearchMoviesFailureLd() {
        return mRepository.getSearchMoviesFailureLd();
    }

    public void requestSearchMovies(String query, int page) {
        mRepository.searchMovies(query, page);
    }


}
