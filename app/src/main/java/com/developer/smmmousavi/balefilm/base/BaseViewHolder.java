package com.developer.smmmousavi.balefilm.base;

import android.view.View;

import com.developer.smmmousavi.balefilm.base.recyclerview.OnRvItemClickListener;
import com.developer.smmmousavi.balefilm.model.BaseModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public abstract class BaseViewHolder<T extends BaseModel> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnRvItemClickListener mOnItemClick;

    public BaseViewHolder(@NonNull ViewBinding viewBinding, OnRvItemClickListener onItemClick) {
        super(viewBinding.getRoot());
        viewBinding.getRoot().setOnClickListener(this);
        mOnItemClick = onItemClick;
    }

    public abstract void bind(T item);


    @Override
    public void onClick(View v) {
        mOnItemClick.onRvItemClick(getAdapterPosition(), v);
    }
}
