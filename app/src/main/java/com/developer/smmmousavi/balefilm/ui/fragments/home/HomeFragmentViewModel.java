package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;
import com.developer.smmmousavi.balefilm.model.Genre;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.repository.MoviesRepository;
import com.developer.smmmousavi.balefilm.repository.GenreRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class HomeFragmentViewModel extends BaseViewModel {

    private static final String TAG = "HomeFragmentViewModel";

    private static final String QUERY_EXHAUSTED = "Suggested recipes query exhausted.";
    private int mPageNumber;
    private String mGenreId;
    private String mSortBy;
    private int mReleaseYear;
    private boolean mIsPerformingRequest;
    private boolean mCancelRequest;
    private boolean mIsQueryExhausted;

    @Inject
    MoviesRepository mMovieRepository;
    @Inject
    GenreRepository mGenreRepository;

    @Inject
    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movie>> getFilteredMoviesLd() {
        return mMovieRepository.getFilteredMoviesLd();
    }

    public LiveData<Boolean> getFilteredMoviesFailureLd() {
        return mMovieRepository.getFilteredMoviesFailureLd();
    }

    public void requestFilteredMovies(String genreId, String sortBy, int releaseYear, int page) {
        mGenreId = genreId;
        mSortBy = sortBy;
        mReleaseYear = releaseYear;
        mPageNumber = page;
        mMovieRepository.requestFilterMovies(mGenreId, mSortBy, mReleaseYear, mPageNumber);
    }

    public LiveData<List<Genre>> getGenresLd() {
        return mGenreRepository.getGenresLd();
    }

    public LiveData<Boolean> getGenresFailureLd() {
        return mGenreRepository.getGenresFailureLd();
    }

    public void requestGenres() {
        mGenreRepository.requestGenres();
    }

}
