package com.developer.smmmousavi.balefilm.fragments.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseDaggerFrgment extends DaggerFragment {

    public BaseDaggerFrgment() {
        // Required empty public constructor
    }

    private BaseFragmentViewModel mViewModel;

    @Inject
    ViewModelProviderFactory mProviderFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_base_dagger, container, false);

        initViewModel();

        return v;
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this, mProviderFactory).get(BaseFragmentViewModel.class);
    }
}
