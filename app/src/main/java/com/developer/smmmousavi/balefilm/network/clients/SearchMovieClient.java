package com.developer.smmmousavi.balefilm.network.clients;

import android.util.Log;

import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.network.factory.MovieRestApiFactory;
import com.developer.smmmousavi.balefilm.network.responses.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchMovieClient {

    private static final String TAG = "FilteredMoviesClient";

    private static SearchMovieClient sInstance;
    private final MutableLiveData<List<Movie>> mFilteredMoviesLd;
    private final MutableLiveData<Boolean> mFilteredMoviesFailLd;
    private boolean mIsPerformingQuery;
    private boolean mIsQueryExhausted;
    private int mPage;


    public static SearchMovieClient getInstance() {
        if (sInstance == null)
            sInstance = new SearchMovieClient();
        return sInstance;
    }

    private SearchMovieClient() {
        mFilteredMoviesLd = new MutableLiveData<>();
        mFilteredMoviesFailLd = new MutableLiveData<>();
    }

    public MutableLiveData<List<Movie>> getSearchMovieLd() {
        return mFilteredMoviesLd;
    }

    public MutableLiveData<Boolean> getSearchMoviesFailureLd() {
        return mFilteredMoviesFailLd;
    }


    public void requestSearchMovies(String query, int page) {
        mPage = page;
        if (mPage == 0)
            mPage = 1;
        MovieRestApiFactory.create()
            .searchMovies(Constants.API_KEY, query, mPage, "popularity.desc")
            .enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.code() == 200) {
                        List<Movie> list = new ArrayList<>(response.body().getMovies());
                        if (mPage == 1) {
                            mFilteredMoviesLd.postValue(list);
                        } else {
                            List<Movie> currentRecipes = mFilteredMoviesLd.getValue();
                            if (currentRecipes != null)
                                currentRecipes.addAll(list);
                            mFilteredMoviesLd.postValue(currentRecipes);
                        }
                    } else {
                        mFilteredMoviesLd.postValue(null);
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    t.printStackTrace();
                    Log.d(TAG, "RETROFIT_ENQUEUE: failed to receive");
                    mFilteredMoviesFailLd.postValue(true);

                }
            });
    }

}
