package com.developer.smmmousavi.balefilm.model;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    private String mName;

    private String mValue;

    public String getName() {
        return mName;
    }

    Sort(String name, String value) {
        mName = name;
        mValue = value;
    }

    public static final String[] SORT_VALUES = {
        "popularity.asc",
        "release_date.asc",
        "revenue.asc",
        "original_title.asc",
        "vote_average.asc",
        "vote_count.asc",
    };

    public static final String[] SORT_Names = {
        "Popularity",
        "Release Date",
        "Revenue",
        "Original Title",
        "Vote Average",
        "Vote Count",
    };


    public static List<Sort> getSortList() {
        List<Sort> sortList = new ArrayList<>();
        for (int i = 0; i < SORT_VALUES.length; i++)
            sortList.add(new Sort(SORT_Names[i], SORT_VALUES[i]));
        return sortList;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        this.mValue = value;
    }

    @Override
    public String toString() {
        return mName;
    }
}
