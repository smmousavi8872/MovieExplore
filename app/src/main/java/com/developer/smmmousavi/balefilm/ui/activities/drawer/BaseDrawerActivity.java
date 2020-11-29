package com.developer.smmmousavi.balefilm.ui.activities.drawer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.developer.smmmousavi.balefilm.R;
import com.developer.smmmousavi.balefilm.databinding.ActivityBaseDrawerBinding;
import com.developer.smmmousavi.balefilm.ui.activities.base.BaseDaggerCompatActivity;
import com.developer.smmmousavi.balefilm.ui.adapter.MainMoviesPagerAdapter;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.util.KeyboardUtils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public abstract class BaseDrawerActivity extends BaseDaggerCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, OnBackPressedListener, SetOnContentFragmentInsert, SetOnToolbarVisibility {

    private static final String TAG = "BaseDrawerActivity";


    private ActivityBaseDrawerBinding mViewBinding;
    private OnBackPressedListener mOnBackPressedListener;
    private BaseDaggerFragment mHostedFragment;
    private boolean mIsToolbarVisible;
    private List<BaseDaggerFragment> mFragmentList;

    public NavigationView getNavigationView() {
        return mViewBinding.navbarView;
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
        mViewBinding = ActivityBaseDrawerBinding.inflate(getLayoutInflater());
        View view = mViewBinding.getRoot();
        setContentView(view);

        setViewListeners();

        setStateBarColor();

        insertContentFragment(this);

        initNavView();

        initButtonNavView();

        initToolbar();

        initViewPager();
    }

    protected void setViewListeners() {
        mViewBinding.mainToolbar.imgNavbarButton.setOnClickListener(V -> mViewBinding.dlMainFragmentDrawer.openDrawer(GravityCompat.START));
        setOnBackPressedListener(this);
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
            mViewBinding.mainToolbar.getRoot().setVisibility(View.GONE);
        } else {
            mIsToolbarVisible = true;
            mViewBinding.mainToolbar.getRoot().setVisibility(View.VISIBLE);
        }
    }

    private void initNavView() {
        mViewBinding.navbarView.setNavigationItemSelectedListener(this);
        mViewBinding.navbarView.getMenu()
            .getItem(0)
            .setChecked(true);
    }

    private void initViewPager() {
        MainMoviesPagerAdapter adapter = new MainMoviesPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        setFragmentList();
        adapter.setFragments(mFragmentList);
        mViewBinding.mainViewPager.setAdapter(adapter);
        mViewBinding.mainViewPager.setOffscreenPageLimit(3);
        mViewBinding.mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mViewBinding.bottomNavView.getMenu().findItem(R.id.navbarHome).setChecked(true);
                        break;
                    case 1:
                        mViewBinding.bottomNavView.getMenu().findItem(R.id.navbarSearch).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setFragmentList() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HomeFragment.newInstance());
        mFragmentList.add(SearchFragment.newInstance());
    }

    private void initButtonNavView() {
        mViewBinding.bottomNavView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navbarHome:
                    if (!(mHostedFragment instanceof HomeFragment)) {
                        KeyboardUtils.hideKeyboard(this);
                        mHostedFragment = HomeFragment.newInstance();
                        mViewBinding.mainViewPager.setCurrentItem(0);
                        /*replaceFragment(R.id.flDrawerContentFragmentContainer,
                            mHostedFragment,
                            HomeFragment.TAG,
                            R.anim.activity_right_to_left,
                            R.anim.activity_right_to_left2,
                            false);*/
                    } else {
                        HomeFragment fragment = (HomeFragment) mFragmentList.get(0);
                        fragment.smoothScrollTop();
                    }
                    break;
                case R.id.navbarSearch:
                    if (!(mHostedFragment instanceof SearchFragment)) {
                        mViewBinding.mainViewPager.setCurrentItem(1);
                        mHostedFragment = SearchFragment.newInstance();
                        if (mHostedFragment instanceof HomeFragment) {
                            /*replaceFragment(R.id.flDrawerContentFragmentContainer,
                                mHostedFragment,
                                SearchFragment.TAG,
                                R.anim.activity_left_to_right,
                                R.anim.activity_left_to_right2,
                                false);*/
                        } /*else if (mHostedFragment instanceof SettingFragment) {
                            mHostedFragment = SearchFragment.newInstance();
                            replaceFragment(R.id.flDrawerContentFragmentContainer,
                                mHostedFragment,
                                SearchFragment.TAG,
                                R.anim.activity_right_to_left,
                                R.anim.activity_right_to_left2,
                                false);
                        }*/
                    } else {
                        SearchFragment fragment = (SearchFragment) mFragmentList.get(1);
                        fragment.smoothScrollTop();
                    }
                    break;
                /*case R.id.navbarSetting:
                    if (!(mHostedFragment instanceof SettingFragment)) {
                        KeyboardUtils.hideKeyboard(this);
                        mHostedFragment = SettingFragment.newInstance();
                        mViewPager.setCurrentItem(2);
                        replaceFragment(R.id.flDrawerContentFragmentContainer,
                            mHostedFragment,
                            SettingFragment.TAG,
                            R.anim.activity_left_to_right,
                            R.anim.activity_left_to_right2,
                            false);
                    }
                    break;*/
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
        mViewBinding.dlMainFragmentDrawer.closeDrawer(GravityCompat.START);
    }

    public boolean isDrawerOpen() {
        return mViewBinding.dlMainFragmentDrawer.isDrawerOpen(GravityCompat.END);
    }

    public void uncheckNavBar() {
        int itemCount = mViewBinding.navbarView.getMenu().size();
        for (int i = 0; i < itemCount; i++) {
            if (mViewBinding.navbarView.getMenu().getItem(i).isChecked()) {
                mViewBinding.navbarView.getMenu().getItem(i).setChecked(false);
            }
        }
    }


    public void insertContentFragment(SetOnContentFragmentInsert contentSet) {
        mHostedFragment = contentSet.getFragmentObject();
       /* int containerId = contentSet.getFragmentId();
        String fragmentTag = contentSet.getFragmentTag();

        Fragment foundFragment = mFm.findFragmentById(containerId);

        if (foundFragment == null) {
            mFm.beginTransaction()
                .add(containerId, mHostedFragment, fragmentTag)
                .commit();
        }*/
    }

    @Override
    public void onBackPressed() {
        if (mViewBinding.dlMainFragmentDrawer.isDrawerOpen(mViewBinding.navbarView))
            mViewBinding.dlMainFragmentDrawer.closeDrawer(GravityCompat.START);
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

