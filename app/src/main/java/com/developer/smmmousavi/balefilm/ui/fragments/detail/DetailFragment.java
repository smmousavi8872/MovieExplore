package com.developer.smmmousavi.balefilm.ui.fragments.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.databinding.FragmentDetailBinding;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.GlideHelper;
import com.developer.smmmousavi.balefilm.model.FetchMovie;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.Objects;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class DetailFragment extends BaseDaggerFragment {

    public static final String TAG = "DetailFragmentTag";
    public static final String ARGS_MOVIE_ID = "ArgsMovieId";

    private FragmentDetailBinding mViewBinding;
    private DetailFragmentViewModel mViewModel;

    private int mMovieId;

    @Inject
    ViewModelProviderFactory mProviderFactory;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(int movieId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_MOVIE_ID, movieId);
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
        mViewBinding = FragmentDetailBinding.inflate(getLayoutInflater());
        View v = mViewBinding.getRoot();
        mMovieId = Objects.requireNonNull(getArguments()).getInt(ARGS_MOVIE_ID);

        setViewListeners();

        subscribeObservers();

        return v;
    }

    private void setViewListeners() {
        mViewBinding.imgBack.setOnClickListener(v -> getActivity().finish());
    }

    public void initViewModel() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(DetailFragmentViewModel.class);
    }

    public void subscribeObservers() {
        mViewModel.requestFetchMovie(mMovieId);
        mViewModel.getFetchedMovieLd().observe(this, movie -> {
            //onChange()
            if (mMovieId == movie.getId()) {
                mMovieId = movie.getId();
                setViewContent(movie);
                showContent(true);
            } else {
                showContent(false);
            }
        });
    }

    private void showContent(boolean show) {
        if (show) {
            mViewBinding.sclMovieContentContainer.setVisibility(View.VISIBLE);
            mViewBinding.clCoverContainer.setVisibility(View.VISIBLE);
            mViewBinding.prgLoadingDetail.setVisibility(View.GONE);
        } else {
            mViewBinding.sclMovieContentContainer.setVisibility(View.GONE);
            mViewBinding.clCoverContainer.setVisibility(View.GONE);
            mViewBinding.prgLoadingDetail.setVisibility(View.VISIBLE);
        }
    }

    private void setViewContent(FetchMovie movie) {
        String url = Constants.TMDB_IMAGE_URL + movie.getBackdropPath();
        String title = movie.getTitle() + movie.getYearText();
        GlideHelper.build(R.drawable.ic_film_placeholder, getContext(), url, mViewBinding.imgMovieCover);
        mViewBinding.txtMovieTitle.setText(title);
        mViewBinding.txtMovieOverview.setText(movie.getOverview());
        mViewBinding.txtTagline.setText(movie.getTagline());
        if (movie.getVoteAverage() >= 10)
            mViewBinding.txtVoteAverage.setText("10");
        else
            mViewBinding.txtVoteAverage.setText(String.valueOf(movie.getVoteAverage()));
        mViewBinding.txtVoteCount.setText(String.valueOf(movie.getVoteCount()));
        mViewBinding.txtReleaseDate.setText(movie.getReleaseDate());
        mViewBinding.txtGenresTitle.setText(movie.getGenresText());
        mViewBinding.txtCompanies.setText(movie.getCompaniesText());
    }

}