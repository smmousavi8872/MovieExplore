package com.developer.smmmousavi.balefilm.repository;

import com.developer.smmmousavi.balefilm.model.Genre;
import com.developer.smmmousavi.balefilm.network.clients.GenreClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class GenreRepository {
    public static final String TAG = "GenreRepositoryTag";

    private static GenreRepository sInstance;
    private final GenreClient mClient;

    private GenreRepository() {
        mClient = GenreClient.getInstance();
    }

    public MutableLiveData<List<Genre>> getGenresLd(){
        return mClient.getGenresLd();
    }
    public MutableLiveData<Boolean> getGenresFailureLd(){
        return mClient.getGenreFailureLd();
    }

    public static GenreRepository getInstance() {
        if (sInstance == null) {
            sInstance = new GenreRepository();
            return sInstance;
        }
        return sInstance;
    }

    public void requestGenres() {
        mClient.requestGenresApi();
    }
}
