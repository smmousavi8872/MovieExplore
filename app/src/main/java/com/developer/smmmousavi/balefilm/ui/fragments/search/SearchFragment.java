package com.developer.smmmousavi.balefilm.ui.fragments.search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.ui.activities.detail.DetailActivity;
import com.developer.smmmousavi.balefilm.ui.adapter.SearchMoviesRvAdapter;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends BaseDaggerFragment implements OnRvItemClickListener {

    public static final String TAG = "SearchFragmentTag";

    @BindView(R.id.prgLoadingSearch)
    ProgressBar mPrgLoading;
    @BindView(R.id.edtSearchMovie)
    AppCompatEditText mEdtSearchMovie;
    @BindView(R.id.searchMoviesRv)
    RecyclerView mSearchMovieRv;

    private SearchFragmentViewModel mViewModel;
    private SearchMoviesRvAdapter<Movie> mSearchMoviesRvAdapter;
    private List<Movie> mMovieList;
    private Handler mRequestHandler;
    private String mQuery;
    private int mPage;
    private boolean mChange;
    private boolean mDidScroll;

    @Inject
    ViewModelProviderFactory mProviderFactory;
    @Inject
    RecyclerViewHelper mRvHelper;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
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
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, v);

        setViewListeners();

        subscribeRvObserver();

        initSearchMovieRv();

        return v;
    }

    public void initViewModel() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(SearchFragmentViewModel.class);
    }

    public void subscribeRvObserver() {
        mViewModel.requestSearchMovies(mQuery, mPage);
        mViewModel.getSearchMoviesLd().removeObservers(this);
        mViewModel.getSearchMoviesLd().observe(this, movies -> {
            mMovieList = movies;
            //onChange()
            if (!mChange) {
                mDidScroll = false;
                mChange = true;
                if (mMovieList != null) {
                    setRvAdapterList(mMovieList);
                } else
                    resetRv();
                mPrgLoading.setVisibility(View.GONE);
            }
        });
        mChange = false;
    }

    private void initSearchMovieRv() {
        mSearchMoviesRvAdapter = new SearchMoviesRvAdapter<>(this);
        LinearLayoutManager layoutManager = mRvHelper.getLinearLayoutManager(getContext(),
            RecyclerViewHelper.Orientation.VERTICAL, false);
        mRvHelper.buildRecyclerView(layoutManager, mSearchMovieRv, mSearchMoviesRvAdapter);
    }

    private void setRvAdapterList(List<Movie> movies) {
        mSearchMoviesRvAdapter.setItemList(movies);
    }

    private void setViewListeners() {
        mEdtSearchMovie.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPrgLoading.setVisibility(View.VISIBLE);
                if (mRequestHandler == null)
                    mRequestHandler = new Handler();
                Runnable runnable = () -> {
                    mQuery = s.toString();
                    Log.d(TAG, "onTextChanged: mQuery = " + mQuery);
                    if (!mQuery.isEmpty())
                        subscribeRvObserver();
                    else
                        resetRv();
                };
                stopHandler();
                mRequestHandler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mSearchMovieRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!mSearchMovieRv.canScrollVertically(1) && !mDidScroll) {
                    mDidScroll = true;
                    mPage++;
                    subscribeRvObserver();
                    Log.d(TAG, "onScrollStateChanged: next page = " + mPage);
                }
            }
        });
    }

    private void stopHandler() {
        mRequestHandler.removeCallbacksAndMessages(null);
    }

    private void resetRv() {
        mPage = 1;
        mPrgLoading.setVisibility(View.GONE);
        mSearchMoviesRvAdapter.clear();
    }

    public void smoothScrollTop() {
        mSearchMovieRv.smoothScrollToPosition(0);
    }

    @Override
    public void onRvItemClick(int position, View view) {
        Log.d(TAG, "onItemClick: position item: " + position);
        int movieId = mMovieList.get(position).getId();
        Intent intent = DetailActivity.newIntent(getContext(), movieId);
        startActivity(intent);
    }
}