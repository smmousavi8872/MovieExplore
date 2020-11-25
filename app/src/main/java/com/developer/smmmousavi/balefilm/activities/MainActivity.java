package com.developer.smmmousavi.balefilm.activities;

import android.os.Bundle;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.activities.base.BaseDaggerCompatActivity;

public class MainActivity extends BaseDaggerCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
