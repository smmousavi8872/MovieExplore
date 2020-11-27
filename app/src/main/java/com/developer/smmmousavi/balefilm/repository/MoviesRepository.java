package com.developer.smmmousavi.balefilm.repository;

import com.developer.smmmousavi.balefilm.model.FetchMovie;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.network.clients.MoviesClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class MoviesRepository {
    public static final String TAG = "MovieRepositoryTag";

    private static MoviesRepository sInstance;
    private final MoviesClient mClient;

    private MoviesRepository() {
        mClient = MoviesClient.getInstance();
    }

    public MutableLiveData<List<Movie>> getFilteredMoviesLd() {
        return mClient.getFilteredMoviesLd();
    }

    public MutableLiveData<Boolean> getFilteredMoviesFailureLd() {
        return mClient.getFilteredMoviesFailureLd();
    }

    public MutableLiveData<FetchMovie> getFetchedMovieLd() {
        return mClient.getFetchedMovieLd();
    }

    public MutableLiveData<Boolean> getFetchedMovieFailureLd() {
        return mClient.getFetchedMoviesFailureLd();
    }

    public static MoviesRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MoviesRepository();
            return sInstance;
        }
        return sInstance;
    }

    public void requestFilterMovies(String genreId, String sortBy, int releaseYear, int page) {
        mClient.requestFilteredMoviesApi(genreId, sortBy, releaseYear, page);
    }

    public void requestFetchMovie(int movieId) {
        mClient.requestFetchedMovieApi(movieId);
    }
}
