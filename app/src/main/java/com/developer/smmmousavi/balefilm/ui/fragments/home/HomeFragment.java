package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.constants.SortValues;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;


public class HomeFragment extends BaseDaggerFragment {

    public static final String TAG = "HomeFragmentTag";

    private HomeFragmentViewModel mViewModel;

    @Inject
    ViewModelProviderFactory mProviderFactory;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        initViewModel();

        subscribeObservers();

        return v;
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(HomeFragmentViewModel.class);
    }

    private void subscribeObservers() {
        mViewModel.requestFilteredMovies("28", SortValues.POPULARITY_DESC, 2020, 1);
        mViewModel.getFilteredMoviesLd().observe(this, movies -> {
            //onChange


        });
    }

}