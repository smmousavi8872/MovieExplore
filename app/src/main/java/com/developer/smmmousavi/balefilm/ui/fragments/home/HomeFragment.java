package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.model.Genre;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.model.Sort;
import com.developer.smmmousavi.balefilm.ui.adapter.MainMoviesRvAdapter;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends BaseDaggerFragment implements OnRvItemClickListener {

    @BindView(R.id.prgLoadingMain)
    ProgressBar mPrgLoading;
    @BindView(R.id.swpRefresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.mainMoviesRv)
    RecyclerView mMainMovieRv;
    @BindView(R.id.sprGenre)
    Spinner mGenresSpinner;
    @BindView(R.id.sprSortBy)
    Spinner mSortBySpinner;
    @BindView(R.id.sprYear)
    Spinner mYearSpinner;

    public static final String TAG = "HomeFragmentTag";

    private HomeFragmentViewModel mViewModel;
    private MainMoviesRvAdapter<Movie> mMainMoviesRvAdapter;
    private Sort mSortBy;
    private Genre mGenre;
    private int mYear;
    private int mPage;
    private boolean mDidScroll;

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
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);

        initViewModel();

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
            initSpinners(genres);

            initValues();

            subscribeRvObserver();
        });
    }

    private void subscribeRvObserver() {
        mPrgLoading.setVisibility(View.VISIBLE);
        mViewModel.requestFilteredMovies(String.valueOf(mGenre.getId()), mSortBy.getValue(), mYear, mPage);
        mViewModel.getFilteredMoviesLd().observe(this, movies -> {
            //onChange()
            if (mRefreshLayout.isRefreshing())
                mRefreshLayout.setRefreshing(false);
            setRvAdapterList(movies);
            mPrgLoading.setVisibility(View.GONE);
            mDidScroll = false;
        });
    }

    private void initSpinners(List<Genre> genres) {
        List<Integer> years = new ArrayList<>();
        for (int i = 2020; i > 1989; i--)
            years.add(i);
        ArrayAdapter<Genre> genreAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, genres);
        mGenresSpinner.setAdapter(genreAdapter);
        ArrayAdapter<Sort> sortAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, Sort.getSortList());
        mSortBySpinner.setAdapter(sortAdapter);
        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, years);
        mYearSpinner.setAdapter(yearAdapter);
    }

    private void initValues() {
        mGenre = (Genre) mGenresSpinner.getItemAtPosition(0);
        mSortBy = (Sort) mSortBySpinner.getItemAtPosition(0);
        mYear = (Integer) mYearSpinner.getItemAtPosition(0);
        mPage = 1;
    }

    private void initMainMoviesRv() {
        mMainMoviesRvAdapter = new MainMoviesRvAdapter<>(this);
        LinearLayoutManager layoutManager = mRvHelper.getGridLayoutManager(getContext(), RecyclerViewHelper.Orientation.VERTICAL, 3);
        mRvHelper.buildRecyclerView(layoutManager, mMainMovieRv, mMainMoviesRvAdapter);
    }

    private void setRvAdapterList(List<Movie> movieList) {
        mMainMoviesRvAdapter.setItemList(movieList);
    }

    private void setListeners() {
        mRefreshLayout.setOnRefreshListener(() -> {
            subscribeRvObserver();
        });

        mGenresSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mGenre = (Genre) mGenresSpinner.getSelectedItem();
                mMainMovieRv.scrollToPosition(0);
                subscribeRvObserver();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        mSortBySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mSortBy = (Sort) mSortBySpinner.getSelectedItem();
                mMainMovieRv.scrollToPosition(0);
                subscribeRvObserver();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        mYearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mYear = (int) mYearSpinner.getSelectedItem();
                mMainMovieRv.scrollToPosition(0);
                subscribeRvObserver();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        mMainMovieRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!mMainMovieRv.canScrollVertically(1) && !mDidScroll) {
                    mDidScroll = true;
                    mPage++;
                    subscribeRvObserver();
                }
            }
        });
    }

    @Override
    public void onItemClick(int position, View view) {
        Log.d(TAG, "onItemClick: position item: " + position);
    }
}