package com.developer.smmmousavi.balefilm.builder.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

public interface OnBuildRecyclerView {

    RecyclerViewBuilder setLayoutManager(RecyclerView.LayoutManager layoutManager);

    RecyclerViewBuilder setItemViewCacheSize(int cacheSize);

    RecyclerViewBuilder setHasFixedSize(boolean hasFixedSize);

    RecyclerViewBuilder setDrawingCacheEnabled(boolean drawingCacheEnabled);

    RecyclerViewBuilder setDrawingCacheQuality(int quality);

    RecyclerViewBuilder setAdapter(RecyclerView.Adapter adapter);

    RecyclerView build();

}
