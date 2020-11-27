package com.developer.smmmousavi.balefilm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ProductionCompany extends BaseModel{

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("logo_path")
    @Expose
    private String logoPath;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("origin_country")
    @Expose
    private String originCountry;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionCompany that = (ProductionCompany) o;
        return id == that.id &&
            Objects.equals(logoPath, that.logoPath) &&
            Objects.equals(name, that.name) &&
            Objects.equals(originCountry, that.originCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logoPath, name, originCountry);
    }

    @Override
    public String toString() {
        return "ProductionCompany{" +
            "id=" + id +
            ", logoPath='" + logoPath + '\'' +
            ", name='" + name + '\'' +
            ", originCountry='" + originCountry + '\'' +
            '}';
    }
}
