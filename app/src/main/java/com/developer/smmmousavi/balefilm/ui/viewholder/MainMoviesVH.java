package com.developer.smmmousavi.balefilm.ui.viewholder;

import android.view.View;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.base.BaseViewHolder;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.constants.Constants;
import com.developer.smmmousavi.balefilm.helper.GlideHelper;
import com.developer.smmmousavi.balefilm.model.Movie;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;

public class MainMoviesVH<T extends Movie> extends BaseViewHolder<T> {

    @BindView(R.id.imgMovieCover)
    AppCompatImageView mPoster;
    @BindView(R.id.txtMovieTitle)
    AppCompatTextView mTitle;

    public MainMoviesVH(@NonNull View itemView, OnRvItemClickListener onItemClick) {
        super(itemView, onItemClick);
    }

    @Override
    public void bind(T item) {
        String url = Constants.TMDB_IMAGE_URL + item.getPosterPath();
        GlideHelper.build(R.drawable.ic_image_24, itemView.getContext(), url, mPoster);
        mTitle.setText(item.getTitle());
    }
}
