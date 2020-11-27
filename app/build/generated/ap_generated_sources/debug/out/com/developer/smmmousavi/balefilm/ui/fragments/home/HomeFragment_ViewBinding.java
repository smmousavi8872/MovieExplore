// Generated code from Butter Knife. Do not modify!
package com.developer.smmmousavi.balefilm.ui.fragments.home;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.developer.smmmousavi.balefilm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  @UiThread
  public HomeFragment_ViewBinding(HomeFragment target, View source) {
    this.target = target;

    target.mPrgMainLoading = Utils.findRequiredViewAsType(source, R.id.prgMainLoading, "field 'mPrgMainLoading'", ProgressBar.class);
    target.mPrgFooterLoading = Utils.findRequiredViewAsType(source, R.id.prgFooterLoading, "field 'mPrgFooterLoading'", ProgressBar.class);
    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swpRefresh, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
    target.mMainMovieRv = Utils.findRequiredViewAsType(source, R.id.mainMoviesRv, "field 'mMainMovieRv'", RecyclerView.class);
    target.mGenresSpinner = Utils.findRequiredViewAsType(source, R.id.sprGenre, "field 'mGenresSpinner'", Spinner.class);
    target.mSortBySpinner = Utils.findRequiredViewAsType(source, R.id.sprSortBy, "field 'mSortBySpinner'", Spinner.class);
    target.mYearSpinner = Utils.findRequiredViewAsType(source, R.id.sprYear, "field 'mYearSpinner'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPrgMainLoading = null;
    target.mPrgFooterLoading = null;
    target.mRefreshLayout = null;
    target.mMainMovieRv = null;
    target.mGenresSpinner = null;
    target.mSortBySpinner = null;
    target.mYearSpinner = null;
  }
}
