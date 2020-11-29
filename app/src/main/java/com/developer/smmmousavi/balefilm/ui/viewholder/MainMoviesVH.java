package com.developer.smmmousavi.balefilm.ui.viewholder;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.base.BaseViewHolder;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.databinding.RowMainMovieBinding;
import com.developer.smmmousavi.balefilm.helper.GlideHelper;
import com.developer.smmmousavi.balefilm.model.Movie;

import androidx.annotation.NonNull;

public class MainMoviesVH<T extends Movie> extends BaseViewHolder<T> {

    private final RowMainMovieBinding mViewBinding;


    public MainMoviesVH(@NonNull RowMainMovieBinding viewBinding, OnRvItemClickListener onItemClick) {
        super(viewBinding, onItemClick);
        mViewBinding = viewBinding;
    }

    @Override
    public void bind(T item) {
        String url = Constants.TMDB_IMAGE_URL + item.getPosterPath();
        GlideHelper.build(R.drawable.ic_film_placeholder, itemView.getContext(), url, mViewBinding.imgMovieCover);
        mViewBinding.txtMovieTitle.setText(item.getTitle());
    }
}
