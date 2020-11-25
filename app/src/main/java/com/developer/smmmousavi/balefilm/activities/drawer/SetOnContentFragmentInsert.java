package com.developer.smmmousavi.balefilm.activities.drawer;

import com.developer.smmmousavi.balefilm.fragments.base.BaseDaggerFragment;

import androidx.annotation.IdRes;

public interface SetOnContentFragmentInsert {

    @IdRes
    int getFragmentId();

    BaseDaggerFragment getFragmentObject();

    String getFragmentTag();
}
