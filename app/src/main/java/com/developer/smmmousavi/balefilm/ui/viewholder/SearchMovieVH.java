package com.developer.smmmousavi.balefilm.ui.viewholder;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.base.BaseViewHolder;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.databinding.RowSearchMovieBinding;
import com.developer.smmmousavi.balefilm.helper.GlideHelper;
import com.developer.smmmousavi.balefilm.model.Movie;

import androidx.annotation.NonNull;

public class SearchMovieVH<T extends Movie> extends BaseViewHolder<T> {

    RowSearchMovieBinding mViewBinding;

    public SearchMovieVH(@NonNull RowSearchMovieBinding viewBinding, OnRvItemClickListener onItemClick) {
        super(viewBinding, onItemClick);
        mViewBinding = viewBinding;
    }

    @Override
    public void bind(T item) {
        String title = item.getTitle() + item.getYearText();
        String url = Constants.TMDB_IMAGE_URL + item.getPosterPath();
        mViewBinding.txtMovieTitle.setText(title);
        mViewBinding.txtMovieOverview.setText(item.getOverview());
        GlideHelper.build(R.drawable.ic_film_placeholder, itemView.getContext(), url, mViewBinding.imgMovieCover);
    }
}
