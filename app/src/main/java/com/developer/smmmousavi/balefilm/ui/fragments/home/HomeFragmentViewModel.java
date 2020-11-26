package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.app.Application;

import com.developer.smmmousavi.balefilm.base.BaseViewModel;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.repository.MovieRepository;

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
    MovieRepository mRepository;

    @Inject
    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movie>> getFilteredMoviesLd() {
        return mRepository.getFilteredMoviesLd();
    }

    public LiveData<Boolean> getFilteredMoviesFailureLd() {
        return mRepository.getFilteredMoviesFailureLd();
    }


    public void requestFilteredMovies(String genreId, String sortBy, int releaseYear, int page) {
        mGenreId = genreId;
        mSortBy = sortBy;
        mReleaseYear = releaseYear;
        if (page == 0) {
            page = 1;
        }
        mPageNumber = page;
        mRepository.requestFilteredMovies(mGenreId, mSortBy, mReleaseYear, mPageNumber);

    }


}
