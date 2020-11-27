package com.developer.smmmousavi.balefilm.network.clients;

import android.util.Log;

import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.model.FetchMovie;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.network.factory.MovieRestApiFactory;
import com.developer.smmmousavi.balefilm.network.responses.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MediatorLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesClient {

    private static final String TAG = "FilteredMoviesClient";

    private static MoviesClient sInstance;
    private final MediatorLiveData<List<Movie>> mFilteredMoviesLd;
    private final MediatorLiveData<Boolean> mFilteredMoviesFailLd;
    private final MediatorLiveData<FetchMovie> mFetchMovieLd;
    private final MediatorLiveData<Boolean> mFetchMoviesFailureLd;
    private boolean mIsPerformingQuery;
    private boolean mIsQueryExhausted;
    private String mSortBy;
    private String mGenreId;
    private int mYear;
    private int mPage;


    public static MoviesClient getInstance() {
        if (sInstance == null)
            sInstance = new MoviesClient();
        return sInstance;
    }

    private MoviesClient() {
        mFilteredMoviesLd = new MediatorLiveData<>();
        mFilteredMoviesFailLd = new MediatorLiveData<>();
        mFetchMovieLd = new MediatorLiveData<>();
        mFetchMoviesFailureLd = new MediatorLiveData<>();
    }

    public MediatorLiveData<List<Movie>> getFilteredMoviesLd() {
        return mFilteredMoviesLd;
    }

    public MediatorLiveData<Boolean> getFilteredMoviesFailureLd() {
        return mFilteredMoviesFailLd;
    }

    public MediatorLiveData<FetchMovie> getFetchedMovieLd() {
        return mFetchMovieLd;
    }

    public MediatorLiveData<Boolean> getFetchedMoviesFailureLd() {
        return mFetchMoviesFailureLd;
    }

    public void requestFilteredMoviesApi(String genreId, String sortBy, int releaseYear, int page) {
        mPage = page;
        if (mPage == 0)
            mPage = 1;
        MovieRestApiFactory.create()
            .getFilteredMovies(Constants.API_KEY, genreId, sortBy, releaseYear, mPage)
            .enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.code() == 200) {
                        List<Movie> list = new ArrayList<>(response.body().getMovies());
                        if (mPage == 1) {
                            mFilteredMoviesLd.postValue(list);
                        } else {
                            List<Movie> currentRecipes = mFilteredMoviesLd.getValue();
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


    public void requestFetchedMovieApi(int movieId) {
        MovieRestApiFactory.create()
            .fetchMovieById(movieId, Constants.API_KEY)
            .enqueue(new Callback<FetchMovie>() {
                @Override
                public void onResponse(Call<FetchMovie> call, Response<FetchMovie> response) {
                    if (response.code() == 200) {
                        mFetchMovieLd.postValue(response.body());
                    } else {
                        mFetchMovieLd.postValue(null);
                    }
                }

                @Override
                public void onFailure(Call<FetchMovie> call, Throwable t) {
                    Log.d(TAG, "RETROFIT_ENQUEUE: failed to receive");
                    mFetchMoviesFailureLd.postValue(true);
                }
            });

    }

}
