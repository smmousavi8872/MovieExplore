package com.developer.smmmousavi.balefilm.network.api;

import com.developer.smmmousavi.balefilm.model.FetchMovie;
import com.developer.smmmousavi.balefilm.network.responses.GenreResponse;
import com.developer.smmmousavi.balefilm.network.responses.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    @GET("genre/movie/list")
    Call<GenreResponse> getGenres(
        @Query("api_key") String apiKey
    );

    @GET("movie/{movie_id}")
    Call<FetchMovie> fetchMovieById(
        @Path("movie_id") int movieId,
        @Query("api_key") String apiKey
    );
}
