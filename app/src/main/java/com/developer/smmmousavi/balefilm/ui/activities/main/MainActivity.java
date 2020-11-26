package com.developer.smmmousavi.balefilm.ui.activities.main;

import com.developer.smmmousavi.balefilm.ui.activities.drawer.BaseDrawerActivity;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment;

public class MainActivity extends BaseDrawerActivity {

    @Override
    public int getFragmentId() {
        return 0;
    }

    @Override
    public BaseDaggerFragment getFragmentObject() {
        return HomeFragment.newInstance();
    }

    @Override
    public String getFragmentTag() {
        return HomeFragment.TAG;
    }

    @Override
    public boolean isToolbarVisible() {
        return true;
    }
}
