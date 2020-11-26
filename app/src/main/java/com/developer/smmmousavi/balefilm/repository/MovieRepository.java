package com.developer.smmmousavi.balefilm.repository;

import com.developer.smmmousavi.balefilm.network.clients.FilteredMoviesClient;
import com.developer.smmmousavi.balefilm.model.Movie;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class MovieRepository {
    public static final String TAG = "MovieRepositoryTag";

    private static MovieRepository sInstance;
    private final FilteredMoviesClient mClient;

    private MovieRepository() {
        mClient = FilteredMoviesClient.getInstance();
    }

    public MutableLiveData<List<Movie>> getFilteredMoviesLd(){
        return mClient.getFilteredMoviesLd();
    }
    public MutableLiveData<Boolean> getFilteredMoviesFailureLd(){
        return mClient.getFilteredMoviesFailureLd();
    }

    public static MovieRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MovieRepository();
            return sInstance;
        }
        return sInstance;
    }

    public void requestFilteredMovies(String genreId, String sortBy, int releaseYear, int page) {
        mClient.requestFilteredMoviesApi(genreId, sortBy, releaseYear, page);
    }

}
