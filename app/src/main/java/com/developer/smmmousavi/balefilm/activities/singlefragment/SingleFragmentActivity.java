package com.developer.smmmousavi.balefilm.activities.singlefragment;

import android.os.Bundle;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.activities.base.BaseDaggerCompatActivity;
import com.developer.smmmousavi.balefilm.factory.SingleFragmentFactory;

import androidx.fragment.app.Fragment;


public abstract class SingleFragmentActivity extends BaseDaggerCompatActivity implements SingleFragmentFactory {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        /*
         * Factory Method Design Pattern
         * Functionality: Client
         */
        insertFragment();
    }

    private void insertFragment() {
        Fragment foundFragment = mFm.findFragmentById(R.id.flSingleFragmentContainer);

        if (foundFragment == null) {
            foundFragment = createFragment();
            String tag = getTag();
            mFm.beginTransaction()
                .add(R.id.flSingleFragmentContainer, foundFragment, tag)
                .commit();
        }
    }
}
