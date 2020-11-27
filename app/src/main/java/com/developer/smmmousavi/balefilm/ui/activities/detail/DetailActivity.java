package com.developer.smmmousavi.balefilm.ui.activities.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.ui.activities.singlefragment.SingleFragmentActivity;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.DetailFragment;

import java.util.Objects;

import androidx.core.content.ContextCompat;

public class DetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_MOVIE_ID = "ExtraMovieId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStateBarColor();
    }

    public static Intent newIntent(Context origin, int movieId) {
        Intent intent = new Intent(origin, DetailActivity.class);
        intent.putExtra(EXTRA_MOVIE_ID, movieId);
        return intent;
    }

    @Override
    public BaseDaggerFragment createFragment() {
        int movieId = Objects.requireNonNull(getIntent().getExtras()).getInt(EXTRA_MOVIE_ID);
        return DetailFragment.newInstance(movieId);
    }

    @Override
    public String getTag() {
        return DetailFragment.TAG;
    }

    private void setStateBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow()
                .setNavigationBarColor(ContextCompat.getColor(this, R.color.pureBlack));
            //status bar or the time bar at the top
            getWindow()
                .setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }
}