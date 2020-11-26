package com.developer.smmmousavi.balefilm.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.base.recyclerview.BaseRvAdapter;
import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
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
    protected RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent, OnRvItemClickListener listener) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main_movie, parent, false);
        return new MainMoviesVH<T>(v, mRvItemClickListener);
    }



    @Override
    protected RecyclerView.ViewHolder createFooterViewHolder(ViewGroup parent) {
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
    public int getItemViewType(int position) {
        return ITEM;
    }
}
