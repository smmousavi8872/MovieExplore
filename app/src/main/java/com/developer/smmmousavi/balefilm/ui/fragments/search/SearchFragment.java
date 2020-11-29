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

import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.databinding.FragmentSearchBinding;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.RecyclerViewHelper;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.ui.activities.detail.DetailActivity;
import com.developer.smmmousavi.balefilm.ui.adapter.SearchMoviesRvAdapter;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchFragment extends BaseDaggerFragment implements OnRvItemClickListener {

    public static final String TAG = "SearchFragmentTag";

    private FragmentSearchBinding mViewBinding;
    private SearchFragmentViewModel mViewModel;
    private SearchMoviesRvAdapter<Movie> mSearchMoviesRvAdapter;
    private List<Movie> mMovieList;
    private Handler mRequestHandler;
    private String mQuery = "";
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
        mViewBinding = FragmentSearchBinding.inflate(getLayoutInflater());
        View  v = mViewBinding.getRoot();

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
                if (mMovieList != null && mMovieList.size() > 0) {
                    setRvAdapterList(mMovieList);
                } else
                    resetRv();
                showSearchLoading(false);
                showFooterLoading(false);
            }
        });
        mChange = false;
    }

    private void initSearchMovieRv() {
        mSearchMoviesRvAdapter = new SearchMoviesRvAdapter<>(this);
        LinearLayoutManager layoutManager = mRvHelper.getLinearLayoutManager(getContext(),
            RecyclerViewHelper.Orientation.VERTICAL, false);
        mRvHelper.buildRecyclerView(layoutManager, mViewBinding.searchMoviesRv, mSearchMoviesRvAdapter);
    }

    private void setRvAdapterList(List<Movie> movies) {
        mSearchMoviesRvAdapter.setItemList(movies);
    }

    private void setViewListeners() {
        mViewBinding.edtSearchMovie.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showSearchLoading(true);

                if (mRequestHandler == null)
                    mRequestHandler = new Handler();
                Runnable runnable = () -> {
                    mQuery = s.toString();
                    if (!mQuery.isEmpty())
                        subscribeRvObserver();
                    else
                        resetRv();
                    if (mPage > 1)
                        resetRv();
                };
                stopHandler();
                mRequestHandler.postDelayed(runnable, 700);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mViewBinding.searchMoviesRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!mViewBinding.searchMoviesRv.canScrollVertically(1) && !mDidScroll) {
                    mDidScroll = true;
                    mPage++;
                    showFooterLoading(true);
                    subscribeRvObserver();
                }
            }
        });
    }

    private void stopHandler() {
        mRequestHandler.removeCallbacksAndMessages(null);
    }

    private void resetRv() {
        mPage = 1;
        showSearchLoading(false);
        mSearchMoviesRvAdapter.clear();
    }

    public void smoothScrollTop() {
        mViewBinding.searchMoviesRv.smoothScrollToPosition(0);
    }

    private void showSearchLoading(boolean show) {
        if (show)
            mViewBinding.prgLoadingSearch.setVisibility(View.VISIBLE);
        else
            mViewBinding.prgLoadingSearch.setVisibility(View.GONE);
    }

    private void showFooterLoading(boolean show) {
        if (show)
            mViewBinding.prgFooterLoading.setVisibility(View.VISIBLE);
        else
            mViewBinding.prgFooterLoading.setVisibility(View.GONE);
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