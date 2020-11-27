package com.developer.smmmousavi.balefilm.network.clients;

import android.util.Log;

import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.model.Genre;
import com.developer.smmmousavi.balefilm.network.factory.MovieRestApiFactory;
import com.developer.smmmousavi.balefilm.network.responses.GenreResponse;

import java.util.List;

import androidx.lifecycle.MediatorLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreClient {

    private static final String TAG = "FilteredMoviesClient";

    private static GenreClient sInstance;
    private final MediatorLiveData<List<Genre>> mGenresLd;
    private final MediatorLiveData<Boolean> mGenresFailureLd;

    public static GenreClient getInstance() {
        if (sInstance == null)
            sInstance = new GenreClient();
        return sInstance;
    }

    private GenreClient() {
        mGenresLd = new MediatorLiveData<>();
        mGenresFailureLd = new MediatorLiveData<>();
    }

    public MediatorLiveData<List<Genre>> getGenresLd() {
        return mGenresLd;
    }

    public MediatorLiveData<Boolean> getGenreFailureLd() {
        return mGenresFailureLd;
    }


    public void requestGenresApi() {
        MovieRestApiFactory.create()
            .getGenres(Constants.API_KEY)
            .enqueue(new Callback<GenreResponse>() {
                @Override
                public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                    Log.d(TAG, "RETROFIT_ENQUEUE: " + response.code());
                    if (response.code() == 200) {
                        mGenresLd.postValue(response.body().getGenres());
                    } else {
                        mGenresLd.postValue(null);
                    }
                }

                @Override
                public void onFailure(Call<GenreResponse> call, Throwable t) {
                    t.printStackTrace();
                    Log.d(TAG, "RETROFIT_ENQUEUE: failed to receive" );
                    mGenresFailureLd.postValue(true);

                }
            });
    }

}
