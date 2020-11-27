package com.developer.smmmousavi.balefilm.ui.fragments.detail;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;
import com.developer.smmmousavi.balefilm.model.FetchMovie;
import com.developer.smmmousavi.balefilm.repository.MoviesRepository;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class DetailFragmentViewModel extends BaseViewModel {

    public MoviesRepository getMovieRepository() {
        return mMovieRepository;
    }

    public void setMovieRepository(MoviesRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    @Inject
    public DetailFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    @Inject
    MoviesRepository mMovieRepository;

    public LiveData<FetchMovie> getFetchedMovieLd() {
        return mMovieRepository.getFetchedMovieLd();
    }

    public LiveData<Boolean> getFetchedFailureLd() {
        return mMovieRepository.getFetchedMovieFailureLd();
    }

    public void requestFetchMovie(int movieId) {
        mMovieRepository.requestFetchMovie(movieId);
    }
}
