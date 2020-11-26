package com.developer.smmmousavi.balefilm.network.api;

import com.developer.smmmousavi.balefilm.network.responses.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieRestApi {

    @GET("discover/movie")
    Call<MovieResponse> getFilteredMovies(
        @Query("api_key") String apiKey,
        @Query("with_genres") String genreId,
        @Query("sort_by") String sortBy,
        @Query("year") int releaseYear,
        @Query("page") int page
    );

    @GET("search/movie")
    Call<MovieResponse> searchMovies(
        @Query("api_key") String apiKey,
        @Query("query") String query,
        @Query("page") int page,
        @Query("sort_by") String sortBy
    );
}
