package com.developer.smmmousavi.balefilm.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.developer.smmmousavi.balefilm.base.BaseViewHolder;
import com.developer.smmmousavi.balefilm.base.recyclerview.BaseRvAdapter;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.databinding.RowMainMovieBinding;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.ui.viewholder.MainMoviesVH;

import androidx.recyclerview.widget.RecyclerView;

public class MainMoviesRvAdapter<T extends Movie> extends BaseRvAdapter<T> {
    OnRvItemClickListener mRvItemClickListener;

    public MainMoviesRvAdapter(OnRvItemClickListener listener) {
        super(listener);
        mRvItemClickListener = listener;
    }

    @Override
    protected BaseViewHolder<T> createHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    protected BaseViewHolder<T> createItemViewHolder(ViewGroup parent, OnRvItemClickListener listener) {
        RowMainMovieBinding viewBinding = RowMainMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MainMoviesVH<T>(viewBinding, mRvItemClickListener);
    }


    @Override
    protected BaseViewHolder<T> createFooterViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    protected void bindHeaderViewHolder(RecyclerView.ViewHolder viewHolder) {

    }

    @Override
    protected void bindItemViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((MainMoviesVH<T>) viewHolder).bind(mItemList.get(position));

    }

    @Override
    protected void bindFooterViewHolder(RecyclerView.ViewHolder viewHolder) {

    }

    @Override
    protected void displayLoadMoreFooter() {

    }

    @Override
    protected void displayErrorFooter() {

    }

    @Override
    protected boolean hasFooter() {
        return false;
    }

    @Override
    public void addFooter() {

    }

    @Override
    public int createItemViewType(int position) {
        return ITEM;
    }


}
