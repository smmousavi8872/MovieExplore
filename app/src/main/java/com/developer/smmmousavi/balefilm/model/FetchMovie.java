package com.developer.smmmousavi.balefilm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Objects;

public class FetchMovie extends BaseModel {

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

    @SerializedName("genres")
    @Expose
    private Genre[] genres;

    @SerializedName("production_companies")
    @Expose
    private ProductionCompany[] productionCompanies;

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("adult")
    @Expose
    private boolean adult;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("tagline")
    @Expose
    private String tagline;

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

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    public ProductionCompany[] getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(ProductionCompany[] productionCompanies) {
        this.productionCompanies = productionCompanies;
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

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchMovie that = (FetchMovie) o;
        return id == that.id &&
            voteCount == that.voteCount &&
            video == that.video &&
            Float.compare(that.voteAverage, voteAverage) == 0 &&
            Float.compare(that.popularity, popularity) == 0 &&
            adult == that.adult &&
            Objects.equals(title, that.title) &&
            Objects.equals(posterPath, that.posterPath) &&
            Objects.equals(originalLanguage, that.originalLanguage) &&
            Objects.equals(originalTitle, that.originalTitle) &&
            Arrays.equals(genres, that.genres) &&
            Objects.equals(backdropPath, that.backdropPath) &&
            Objects.equals(overview, that.overview) &&
            Objects.equals(tagline, that.tagline) &&
            Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, voteCount, video, voteAverage, popularity, posterPath, originalLanguage, originalTitle, backdropPath, adult, overview, tagline, releaseDate);
        result = 31 * result + Arrays.hashCode(genres);
        return result;
    }

    @Override
    public String toString() {
        return "FetchMovie{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", voteCount=" + voteCount +
            ", video=" + video +
            ", voteAverage=" + voteAverage +
            ", popularity=" + popularity +
            ", posterPath='" + posterPath + '\'' +
            ", originalLanguage='" + originalLanguage + '\'' +
            ", originalTitle='" + originalTitle + '\'' +
            ", genreIds=" + Arrays.toString(genres) +
            ", backdropPath='" + backdropPath + '\'' +
            ", adult=" + adult +
            ", overview='" + overview + '\'' +
            ", tagline='" + tagline + '\'' +
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

    public String getGenresText() {
        try {
            String genresTitle = "";
            for (int i = 0; i < genres.length; i++) {
                if (i < genres.length - 1)
                    genresTitle = genresTitle.concat(genres[i].getName() + ", ");
                else
                    genresTitle = genresTitle.concat(genres[i].getName());
            }
            return genresTitle;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getCompaniesText() {
        try {
            String genresTitle = "";
            for (int i = 0; i < productionCompanies.length; i++) {
                if (i < productionCompanies.length - 1)
                    genresTitle = genresTitle.concat(productionCompanies[i].getName() + ", ");
                else
                    genresTitle = genresTitle.concat(productionCompanies[i].getName());
            }
            return genresTitle;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
