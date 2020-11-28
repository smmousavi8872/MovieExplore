package com.developer.smmmousavi.balefilm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Objects;

public class Movie extends BaseModel {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    @SerializedName("video")
    @Expose
    private boolean video;

    @SerializedName("vote_average")
    @Expose
    private float voteAverage;

    @SerializedName("popularity")
    @Expose
    private float popularity;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @SerializedName("genre_ids")
    @Expose
    private int[] genreIds;

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("adult")
    @Expose
    private boolean adult;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(int[] genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
            voteCount == movie.voteCount &&
            video == movie.video &&
            Float.compare(movie.voteAverage, voteAverage) == 0 &&
            Float.compare(movie.popularity, popularity) == 0 &&
            adult == movie.adult &&
            Objects.equals(title, movie.title) &&
            Objects.equals(posterPath, movie.posterPath) &&
            Objects.equals(originalLanguage, movie.originalLanguage) &&
            Objects.equals(originalTitle, movie.originalTitle) &&
            Arrays.equals(genreIds, movie.genreIds) &&
            Objects.equals(backdropPath, movie.backdropPath) &&
            Objects.equals(overview, movie.overview) &&
            Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, voteCount, video, voteAverage, popularity, posterPath,
            originalLanguage, originalTitle, backdropPath, adult, overview, releaseDate);
        result = 31 * result + Arrays.hashCode(genreIds);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", voteCount=" + voteCount +
            ", video=" + video +
            ", voteAverage=" + voteAverage +
            ", popularity=" + popularity +
            ", posterPath='" + posterPath + '\'' +
            ", originalLanguage='" + originalLanguage + '\'' +
            ", originalTitle='" + originalTitle + '\'' +
            ", genreIds=" + Arrays.toString(genreIds) +
            ", backdropPath='" + backdropPath + '\'' +
            ", adult=" + adult +
            ", overview='" + overview + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            '}';
    }

    public String getYearText() {
        try {
            String year = releaseDate;
            if (year == null)
                year = "";
            else {
                year = " (" + year.substring(0, year.indexOf("-")) + ")";
            }
            return year;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
