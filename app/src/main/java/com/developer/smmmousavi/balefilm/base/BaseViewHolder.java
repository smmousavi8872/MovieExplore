package com.developer.smmmousavi.balefilm.base;

import android.view.View;

import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnRvItemClickListener mOnItemClick;

    public BaseViewHolder(@NonNull View itemView, OnRvItemClickListener onItemClick) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mOnItemClick = onItemClick;
    }

    public abstract void bind(T item);


    @Override
    public void onClick(View v) {
        mOnItemClick.onRvItemClick(getAdapterPosition(), v);
    }
}
