package com.developer.smmmousavi.balefilm.ui.activities.drawer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.ui.activities.base.BaseDaggerCompatActivity;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.setting.SettingFragment;
import com.developer.smmmousavi.balefilm.util.KeyboardUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
    @BindView(R.id.bottomNavView)
    BottomNavigationView mBottomNavigationView;

    private OnBackPressedListener mOnBackPressedListener;
    private BaseDaggerFragment mHostedFragment;
    private boolean mIsToolbarVisible;

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

        initButtonNavView();

        initToolbar();
    }

    private void setStateBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow()
                .setNavigationBarColor(ContextCompat.getColor(this, R.color.pureBlack));
            //status bar or the time bar at the top
            getWindow()
                .setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }

    private void initToolbar() {
        mIsToolbarVisible = isToolbarVisible();
        showToolbar(mIsToolbarVisible);
    }

    private void showToolbar(boolean show) {
        if (!show) {
            mIsToolbarVisible = false;
            mToolbarLayout.setVisibility(View.GONE);
        } else {
            mIsToolbarVisible = true;
            mToolbarLayout.setVisibility(View.VISIBLE);
        }
    }

    private void initNavView() {
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.getMenu()
            .getItem(0)
            .setChecked(true);
    }

    private void initButtonNavView() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navbarHome:
                    if (!(mHostedFragment instanceof HomeFragment)) {
                        KeyboardUtils.hideKeyboard(this);
                        mHostedFragment = HomeFragment.newInstance();
                        replaceFragment(R.id.flDrawerContentFragmentContainer,
                            mHostedFragment,
                            HomeFragment.TAG,
                            R.anim.activity_right_to_left,
                            R.anim.activity_right_to_left2,
                            false);
                    }
                    break;
                case R.id.navbarSearch:
                    if (!(mHostedFragment instanceof SearchFragment)) {
                        if (mHostedFragment instanceof HomeFragment) {
                            mHostedFragment = SearchFragment.newInstance();
                            replaceFragment(R.id.flDrawerContentFragmentContainer,
                                mHostedFragment,
                                SearchFragment.TAG,
                                R.anim.activity_left_to_right,
                                R.anim.activity_left_to_right2,
                                false);
                        } else if (mHostedFragment instanceof SettingFragment) {
                            mHostedFragment = SearchFragment.newInstance();
                            replaceFragment(R.id.flDrawerContentFragmentContainer,
                                mHostedFragment,
                                SearchFragment.TAG,
                                R.anim.activity_right_to_left,
                                R.anim.activity_right_to_left2,
                                false);
                        }
                    }
                    break;
                case R.id.navbarSetting:
                    if (!(mHostedFragment instanceof SettingFragment)) {
                        KeyboardUtils.hideKeyboard(this);
                        mHostedFragment = SettingFragment.newInstance();
                        replaceFragment(R.id.flDrawerContentFragmentContainer,
                            mHostedFragment,
                            SettingFragment.TAG,
                            R.anim.activity_left_to_right,
                            R.anim.activity_left_to_right2,
                            false);
                    }
                    break;
            }
            return true;
        });
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
        Intent intent = null;
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
        mHostedFragment = contentSet.getFragmentObject();
        int containerId = contentSet.getFragmentId();
        String fragmentTag = contentSet.getFragmentTag();

        Fragment foundFragment = mFm.findFragmentById(containerId);

        if (foundFragment == null) {
            mFm.beginTransaction()
                .add(containerId, mHostedFragment, fragmentTag)
                .commit();
        }
    }

    public void replaceFragment(@IdRes int containerId,
                                @NonNull BaseDaggerFragment newFragment,
                                @NonNull String newTag,
                                @AnimatorRes @AnimRes int enterAnimId,
                                @AnimatorRes @AnimRes int exitAnimId,
                                boolean popPrevious) {

        assert getFragmentManager() != null;
        FragmentManager fm = getSupportFragmentManager();
        BaseDaggerFragment foundFragment = (BaseDaggerFragment) fm.findFragmentByTag(newTag);
        if (popPrevious) {
            int frgCount = fm.getBackStackEntryCount();
            if (frgCount > 0)
                fm.popBackStack();
        }

        if (foundFragment == null)
            fm.beginTransaction()
                .setCustomAnimations(enterAnimId, exitAnimId)
                .replace(containerId, newFragment, newTag)
                .addToBackStack(newTag)
                .commit();
        else
            fm.beginTransaction()
                .setCustomAnimations(enterAnimId, exitAnimId)
                .replace(containerId, newFragment, newTag)
                .commit();
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
        else {
            FragmentManager fm = getSupportFragmentManager();
            for (int i = 0; i < fm.getBackStackEntryCount(); ++i)
                fm.popBackStack();
            super.onBackPressed();
        }
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

