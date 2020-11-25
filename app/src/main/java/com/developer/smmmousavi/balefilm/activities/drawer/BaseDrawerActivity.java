package com.developer.smmmousavi.balefilm.activities.drawer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.activities.base.BaseDaggerCompatActivity;
import com.developer.smmmousavi.balefilm.fragments.home.HomeFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseDrawerActivity extends BaseDaggerCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, OnBackPressedListener, SetOnContentFragmentInsert, SetOnToolbarVisibility {


    @BindView(R.id.imgNavbarButton)
    AppCompatImageView imgNavbarButton;
    @BindView(R.id.navbarView)
    NavigationView mNavigationView;
    @BindView(R.id.dlMainFragmentDrawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.mainToolbar)
    AppBarLayout mToolbarLayout;

    private AppCompatTextView mTxtSignupButton;
    private OnBackPressedListener mOnBackPressedListener;

    public NavigationView getNavigationView() {
        return mNavigationView;
    }

    public void setOnBackPressedListener(OnBackPressedListener listener) {
        mOnBackPressedListener = listener;
    }

    @Override
    protected void onResume() {
        super.onResume();
        uncheckNavBar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_drawer);
        ButterKnife.bind(this);

        setStateBarColor();

        insertContentFragment(this);

        initNavView();

        initToolbar();
    }

    private void setStateBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow()
                .setNavigationBarColor(ContextCompat.getColor(this, R.color.pureWhite));
            //status bar or the time bar at the top
            getWindow()
                .setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }


    private void initToolbar() {
        if (!isToolbarVisible())
            mToolbarLayout.setVisibility(View.GONE);
        //TODO: should set the shopping basket count to mTxtShoppingBasketBadge, using SharedPrefUtils
        //should implement search icon functionality in toolbar
    }


    private void initNavView() {
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.getMenu()
            .getItem(0)
            .setChecked(true);

    /*    // to set listener on views of header, first shoud find them
        // here is how to get NavigationView header
        View navHeader = mNavigationView.getHeaderView(0);
        mTxtSignupButton = navHeader.findViewById(R.id.txtNavbarSignUpButton);
        mTxtSignupButton.setOnClickListener(v -> {
            startActivity(SignInSignUpActivity.newIntent(this));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            new Handler().postDelayed(this::closeDrawer, 600);
        });*/
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        item.setChecked(true);
        setNavigationItemAction(item);

        //new Handler().postDelayed(this::closeDrawer, 150);
        return true;
    }

    private void setNavigationItemAction(@NonNull MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {

        }
        closeDrawer();
        if (intent != null)
            startActivity(intent);
        new Handler().postDelayed(() -> {
        }, 200);
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.END);
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.END);
    }

    public void uncheckNavBar() {
        int itemCount = mNavigationView.getMenu().size();
        for (int i = 0; i < itemCount; i++) {
            if (mNavigationView.getMenu().getItem(i).isChecked()) {
                mNavigationView.getMenu().getItem(i).setChecked(false);
            }
        }
    }


    public void insertContentFragment(SetOnContentFragmentInsert contentSet) {
        int containerId = contentSet.getFragmentId();
        Fragment fragmentObject = contentSet.getFragmentObject();
        String fragmentTag = contentSet.getFragmentTag();

        Fragment foundFragment = mFm.findFragmentById(containerId);

        if (foundFragment == null) {
            mFm.beginTransaction()
                .add(containerId, fragmentObject, fragmentTag)
                .commit();
        }
    }

    @OnClick(R.id.imgNavbarButton)
    void setNavBarListener() {
        HomeFragment homeDrawerFragment = (HomeFragment) mFm.findFragmentByTag(HomeFragment.TAG);
        if (homeDrawerFragment != null)
            mDrawerLayout.openDrawer(GravityCompat.START);
        setOnBackPressedListener(this);
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mNavigationView))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navbar, menu);
        return true;
    }


    @Override
    public void onBack() {
        closeDrawer();

    }
}

