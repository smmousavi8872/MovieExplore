package com.developer.smmmousavi.balefilm.ui.adapter;

import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainMoviesPagerAdapter extends FragmentPagerAdapter {

    List<BaseDaggerFragment> mFragments;

    public void setFragments(List<BaseDaggerFragment> fragments) {
        mFragments = fragments;
    }

    public MainMoviesPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        if (mFragments != null)
            return mFragments.size();
        else
            return 0;
    }
}
