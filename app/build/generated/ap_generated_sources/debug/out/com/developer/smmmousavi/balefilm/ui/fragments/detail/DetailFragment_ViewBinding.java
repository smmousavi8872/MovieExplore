// Generated code from Butter Knife. Do not modify!
package com.developer.smmmousavi.balefilm.ui.fragments.detail;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.developer.smmmousavi.balefilm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailFragment_ViewBinding implements Unbinder {
  private DetailFragment target;

  @UiThread
  public DetailFragment_ViewBinding(DetailFragment target, View source) {
    this.target = target;

    target.mPrgLoading = Utils.findRequiredViewAsType(source, R.id.prgLoadingDetail, "field 'mPrgLoading'", ProgressBar.class);
    target.mSclMovieContentContainer = Utils.findRequiredViewAsType(source, R.id.sclMovieContentContainer, "field 'mSclMovieContentContainer'", ScrollView.class);
    target.mImgMovieCover = Utils.findRequiredViewAsType(source, R.id.imgMovieCover, "field 'mImgMovieCover'", AppCompatImageView.class);
    target.mTxtMovieTitle = Utils.findRequiredViewAsType(source, R.id.txtMovieTitle, "field 'mTxtMovieTitle'", AppCompatTextView.class);
    target.mTxtMovieOverview = Utils.findRequiredViewAsType(source, R.id.txtMovieOverview, "field 'mTxtMovieOverview'", AppCompatTextView.class);
    target.mTxtTagline = Utils.findRequiredViewAsType(source, R.id.txtTagline, "field 'mTxtTagline'", AppCompatTextView.class);
    target.mTxtReleaseDate = Utils.findRequiredViewAsType(source, R.id.txtReleaseDate, "field 'mTxtReleaseDate'", AppCompatTextView.class);
    target.mTxtGenresTitle = Utils.findRequiredViewAsType(source, R.id.txtGenres, "field 'mTxtGenresTitle'", AppCompatTextView.class);
    target.mTxtDirector = Utils.findRequiredViewAsType(source, R.id.txtMovieDirector, "field 'mTxtDirector'", AppCompatTextView.class);
    target.mTxtProductionCompanies = Utils.findRequiredViewAsType(source, R.id.txtCompanies, "field 'mTxtProductionCompanies'", AppCompatTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPrgLoading = null;
    target.mSclMovieContentContainer = null;
    target.mImgMovieCover = null;
    target.mTxtMovieTitle = null;
    target.mTxtMovieOverview = null;
    target.mTxtTagline = null;
    target.mTxtReleaseDate = null;
    target.mTxtGenresTitle = null;
    target.mTxtDirector = null;
    target.mTxtProductionCompanies = null;
  }
}
