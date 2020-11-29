package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.databinding.FragmentHomeBinding;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.model.Genre;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.model.Sort;
import com.developer.smmmousavi.balefilm.ui.activities.detail.DetailActivity;
import com.developer.smmmousavi.balefilm.ui.adapter.MainMoviesRvAdapter;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeFragment extends BaseDaggerFragment implements OnRvItemClickListener {


    public static final String TAG = "HomeFragmentTag";

    private FragmentHomeBinding mViewBinding;
    private HomeFragmentViewModel mViewModel;
    private MainMoviesRvAdapter<Movie> mMainMoviesRvAdapter;
    private List<Movie> mMovieList;
    private Sort mSortBy;
    private Genre mGenre;
    private int mYear;
    private int mPage;
    private boolean mDidScroll;
    private boolean mChange;

    @Inject
    ViewModelProviderFactory mProviderFactory;
    @Inject
    RecyclerViewHelper mRvHelper;

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

        initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mViewBinding = FragmentHomeBinding.inflate(getLayoutInflater());
        View v = mViewBinding.getRoot();

        setListeners();

        subscribeSpinnersObserver();

        initMainMoviesRv();

        return v;
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(HomeFragmentViewModel.class);
    }

    private void subscribeSpinnersObserver() {
        mViewModel.requestGenres();
        mViewModel.getGenresLd().observe(this, genres -> {
            //onChange()
            Log.d(TAG, "subscribeRvObserver:  spinner onchange!");
            initSpinners(genres);

            initValues();

            subscribeRvObserver();
        });
    }

    private void subscribeRvObserver() {
        mViewModel.requestFilteredMovies(String.valueOf(mGenre.getId()), mSortBy.getValue(), mYear, mPage);
        mViewModel.getFilteredMoviesLd().removeObservers(this);
        mViewModel.getFilteredMoviesLd().observe(this, movies -> {
            mMovieList = movies;
            //onChange()
            if (!mChange) {
                Log.d(TAG, "subscribeRvObserver:  Rv onchange!");
                if (mViewBinding.swpRefreshLayout.isRefreshing())
                    mViewBinding.swpRefreshLayout.setRefreshing(false);
                setRvAdapterList(mMovieList);
                mDidScroll = false;
                mChange = true;
                showMainLoading(false);
                showFooterLoading(false);
            }
        });
        mChange = false;
    }

    private void initSpinners(List<Genre> genres) {
        List<Integer> years = new ArrayList<>();
        for (int i = 2020; i > 1989; i--)
            years.add(i);
        ArrayAdapter<Genre> genreAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, genres);
        mViewBinding.sprGenre.setAdapter(genreAdapter);
        ArrayAdapter<Sort> sortAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, Sort.getSortList());
        mViewBinding.sprSortBy.setAdapter(sortAdapter);
        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, years);
        mViewBinding.sprYear.setAdapter(yearAdapter);
    }

    private void initValues() {
        mGenre = (Genre) mViewBinding.sprGenre.getItemAtPosition(0);
        mSortBy = (Sort) mViewBinding.sprSortBy.getItemAtPosition(0);
        mYear = (Integer) mViewBinding.sprYear.getItemAtPosition(0);
        mPage = 1;
    }

    private void initMainMoviesRv() {
        mMainMoviesRvAdapter = new MainMoviesRvAdapter<>(this);
        LinearLayoutManager layoutManager = mRvHelper.getGridLayoutManager(getContext(), RecyclerViewHelper.Orientation.VERTICAL, 3);
        mRvHelper.buildRecyclerView(layoutManager, mViewBinding.mainMoviesRv, mMainMoviesRvAdapter);
    }

    private void setRvAdapterList(List<Movie> movieList) {
        mMainMoviesRvAdapter.setItemList(movieList);
    }

    private void setListeners() {

        mViewBinding.swpRefreshLayout.setOnRefreshListener(() -> {
            resetRv();
            subscribeRvObserver();
        });

        mViewBinding.sprGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mGenre = (Genre) mViewBinding.sprGenre.getSelectedItem();
                resetRv();
                subscribeRvObserver();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        mViewBinding.sprSortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mSortBy = (Sort) mViewBinding.sprSortBy.getSelectedItem();
                resetRv();
                subscribeRvObserver();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        mViewBinding.sprYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mYear = (int) mViewBinding.sprYear.getSelectedItem();
                resetRv();
                subscribeRvObserver();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        mViewBinding.mainMoviesRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!mViewBinding.mainMoviesRv.canScrollVertically(1) && !mDidScroll) {
                    mDidScroll = true;
                    mPage++;
                    subscribeRvObserver();
                    showFooterLoading(true);
                    Log.d(TAG, "onScrollStateChanged: next page = " + mPage);
                }
            }
        });
    }

    private void resetRv() {
        mPage = 1;
        mMainMoviesRvAdapter.clear();
        showMainLoading(true);
    }

    private void showFooterLoading(boolean show) {
        if (show)
            mViewBinding.prgFooterLoading.setVisibility(View.VISIBLE);
        else
            mViewBinding.prgFooterLoading.setVisibility(View.GONE);
    }

    private void showMainLoading(boolean show) {
        if (show)
            mViewBinding.prgMainLoading.setVisibility(View.VISIBLE);
        else
            mViewBinding.prgMainLoading.setVisibility(View.GONE);
    }

    public void smoothScrollTop() {
        mViewBinding.mainMoviesRv.scrollToPosition(0);
    }

    @Override
    public void onRvItemClick(int position, View view) {
        Log.d(TAG, "onItemClick: position item: " + position);
        int movieId = mMovieList.get(position).getId();
        Intent intent = DetailActivity.newIntent(getContext(), movieId);
        startActivity(intent);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        resetRv();
    }
}