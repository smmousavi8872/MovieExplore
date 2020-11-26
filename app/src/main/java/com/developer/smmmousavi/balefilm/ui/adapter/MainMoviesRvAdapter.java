package com.developer.smmmousavi.balefilm.ui.adapter;

import android.view.ViewGroup;

import com.developer.smmmousavi.balefilm.base.recyclerview.BaseRvAdapter;
import com.developer.smmmousavi.balefilm.model.Movie;
import com.developer.smmmousavi.balefilm.ui.viewholder.MainMoviesVH;

import androidx.recyclerview.widget.RecyclerView;

public class MainMoviesRvAdapter<T extends Movie> extends BaseRvAdapter<MainMoviesVH<T>> {
    @Override
    protected RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent) {
        return null;
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
}
