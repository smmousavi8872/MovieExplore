package com.developer.smmmousavi.balefilm.ui.fragments.base;

import android.os.Bundle;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseDaggerFragment extends DaggerFragment {

    public BaseDaggerFragment() {
        // Required empty public constructor
    }

    private FragmentManager mFm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFm = getFragmentManager();
    }

    public void replaceFragment(@IdRes int containerId,
                                @NonNull BaseDaggerFragment newFragment,
                                @NonNull String newTag,
                                @AnimatorRes @AnimRes int enterAnimId,
                                @AnimatorRes @AnimRes int exitAnimId,
                                boolean popPrevious) {

        assert getFragmentManager() != null;

        BaseDaggerFragment foundFragment = (BaseDaggerFragment) mFm.findFragmentByTag(newTag);
        if (popPrevious) {
            int frgCount = mFm.getBackStackEntryCount();
            if (frgCount > 0)
                mFm.popBackStack();
        }

        if (foundFragment == null)
            mFm.beginTransaction()
                .setCustomAnimations(enterAnimId, exitAnimId)
                .replace(containerId, newFragment, newTag)
                .addToBackStack(newTag)
                .commit();
        else
            mFm.beginTransaction()
                .setCustomAnimations(enterAnimId, exitAnimId)
                .replace(containerId, newFragment, newTag)
                .commit();
    }





}
