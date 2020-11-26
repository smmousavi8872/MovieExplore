package com.developer.smmmousavi.balefilm.ui.activities.drawer;

import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

import androidx.annotation.IdRes;

public interface SetOnContentFragmentInsert {

    @IdRes
    int getFragmentId();

    BaseDaggerFragment getFragmentObject();

    String getFragmentTag();
}
