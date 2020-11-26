package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.util.Log;

import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.network.factory.MovieRestApiFactory;
import com.developer.smmmousavi.balefilm.network.responses.MovieResponse;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilteredMoviesClient {

    private static final String TAG = "FilteredMoviesClient";

    private static FilteredMoviesClient sInstance;
    private final MutableLiveData<List<Movie>> mFilteredMoviesLd;
    private final MutableLiveData<Boolean> mFilteredMoviesFailLd;

    public static FilteredMoviesClient getInstance() {
        if (sInstance == null)
            sInstance = new FilteredMoviesClient();
        return sInstance;
    }

    private FilteredMoviesClient() {
        mFilteredMoviesLd = new MutableLiveData<>();
        mFilteredMoviesFailLd = new MutableLiveData<>();
    }

    public MutableLiveData<List<Movie>> getFilteredMoviesLd() {
        return mFilteredMoviesLd;
    }

    public MutableLiveData<Boolean> getFilteredMoviesFailureLd() {
        return mFilteredMoviesFailLd;
    }


    public void requestFilteredMoviesApi(String genreId, String sortBy, int releaseYear, int page) {
        MovieRestApiFactory.create()
            .getFilteredMovies(Constants.API_KEY, genreId, sortBy, releaseYear, page)
            .enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    Log.d(TAG, "RETROFIT_ENQUEUE: " + response.code());
                    if (response.code() == 200) {
                        mFilteredMoviesLd.postValue(response.body().getMovies());
                    } else {
                        mFilteredMoviesLd.postValue(null);
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    t.printStackTrace();
                    Log.d(TAG, "RETROFIT_ENQUEUE: failed to receive" );
                    mFilteredMoviesFailLd.postValue(true);

                }
            });
    }

}
