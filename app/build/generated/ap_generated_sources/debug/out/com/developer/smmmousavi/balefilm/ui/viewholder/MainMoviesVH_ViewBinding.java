// Generated code from Butter Knife. Do not modify!
package com.developer.smmmousavi.balefilm.ui.viewholder;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.developer.smmmousavi.balefilm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainMoviesVH_ViewBinding implements Unbinder {
  private MainMoviesVH target;

  @UiThread
  public MainMoviesVH_ViewBinding(MainMoviesVH target, View source) {
    this.target = target;

    target.mPoster = Utils.findRequiredViewAsType(source, R.id.imgMovieCover, "field 'mPoster'", AppCompatImageView.class);
    target.mTitle = Utils.findRequiredViewAsType(source, R.id.txtMovieTitle, "field 'mTitle'", AppCompatTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainMoviesVH target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPoster = null;
    target.mTitle = null;
  }
}