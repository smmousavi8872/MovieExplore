package com.developer.smmmousavi.balefilm.repository;

import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.network.clients.SearchMovieClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class SearchMovieRepository {

    public static final String TAG = "MovieRepositoryTag";

    private static SearchMovieRepository sInstance;
    private final SearchMovieClient mClient;

    private SearchMovieRepository() {
        mClient = SearchMovieClient.getInstance();
    }

    public MutableLiveData<List<Movie>> getSearchMovieLd(){
        return mClient.getSearchMovieLd();
    }
    public MutableLiveData<Boolean> getSearchMoviesFailureLd(){
        return mClient.getSearchMoviesFailureLd();
    }

    public static SearchMovieRepository getInstance() {
        if (sInstance == null) {
            sInstance = new SearchMovieRepository();
            return sInstance;
        }
        return sInstance;
    }

    public void searchMovies(String query, int page) {
        mClient.requestSearchMovies(query, page);
    }
}
