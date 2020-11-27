package com.developer.smmmousavi.balefilm.ui.fragments.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.helper.GlideHelper;
import com.developer.smmmousavi.balefilm.model.FetchMovie;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import java.util.Objects;

import javax.inject.Inject;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailFragment extends BaseDaggerFragment {

    public static final String TAG = "DetailFragmentTag";
    public static final String ARGS_MOVIE_ID = "ArgsMovieId";

    @BindView(R.id.prgLoadingDetail)
    ProgressBar mPrgLoading;
    @BindView(R.id.clCoverContainer)
    ConstraintLayout mCoverContainer;
    @BindView(R.id.sclMovieContentContainer)
    ScrollView mSclMovieContentContainer;
    @BindView(R.id.imgMovieCover)
    AppCompatImageView mImgMovieCover;
    @BindView(R.id.txtMovieTitle)
    AppCompatTextView mTxtMovieTitle;
    @BindView(R.id.txtMovieOverview)
    AppCompatTextView mTxtMovieOverview;
    @BindView(R.id.txtTagline)
    AppCompatTextView mTxtTagline;
    @BindView(R.id.txtReleaseDate)
    AppCompatTextView mTxtReleaseDate;
    @BindView(R.id.txtGenres)
    AppCompatTextView mTxtGenresTitle;
    @BindView(R.id.txtMovieDirector)
    AppCompatTextView mTxtDirector;
    @BindView(R.id.txtCompanies)
    AppCompatTextView mTxtProductionCompanies;

    private DetailFragmentViewModel mViewModel;
    private boolean mChange;

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
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, v);
        mMovieId = Objects.requireNonNull(getArguments()).getInt(ARGS_MOVIE_ID);
        Log.d(TAG, "onCreateView: called");

        subscribeObservers();

        return v;
    }


    public void initViewModel() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(DetailFragmentViewModel.class);
    }


    public void subscribeObservers() {
        mViewModel.requestFetchMovie(mMovieId);
        mViewModel.getFetchedMovieLd().observe(this, movie -> {
            //onChange()
            Log.d(TAG, "onChangeDetail: called");
            setViewContent(movie);
            showContent(true);
        });
    }

    private void showContent(boolean show) {
        if (show) {
            mSclMovieContentContainer.setVisibility(View.VISIBLE);
            mCoverContainer.setVisibility(View.VISIBLE);
            mPrgLoading.setVisibility(View.GONE);
        } else {
            mPrgLoading.setVisibility(View.VISIBLE);
            mSclMovieContentContainer.setVisibility(View.GONE);
            mCoverContainer.setVisibility(View.GONE);
        }
    }

    private void setViewContent(FetchMovie movie) {
        String url = Constants.TMDB_IMAGE_URL + movie.getBackdropPath();
        String title = movie.getTitle() + movie.getYearText();
        GlideHelper.build(R.drawable.ic_film_placeholder, getContext(), url, mImgMovieCover);
        mTxtMovieTitle.setText(title);
        mTxtMovieOverview.setText(movie.getOverview());
        mTxtTagline.setText(movie.getTagline());
        mTxtReleaseDate.setText(movie.getReleaseDate());
        mTxtGenresTitle.setText(movie.getGenresText());
        mTxtProductionCompanies.setText(movie.getCompaniesText());
    }

    @OnClick(R.id.imgBack)
    void setOnBackClickListener() {
        Objects.requireNonNull(getActivity()).finish();
    }
}