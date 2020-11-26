// Generated code from Butter Knife. Do not modify!
package com.developer.smmmousavi.balefilm.ui.fragments.search;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.developer.smmmousavi.balefilm.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchFragment_ViewBinding implements Unbinder {
  private SearchFragment target;

  @UiThread
  public SearchFragment_ViewBinding(SearchFragment target, View source) {
    this.target = target;

    target.mPrgLoading = Utils.findRequiredViewAsType(source, R.id.prgLoadingSearch, "field 'mPrgLoading'", ProgressBar.class);
    target.mEdtSearchMovie = Utils.findRequiredViewAsType(source, R.id.edtSearchMovie, "field 'mEdtSearchMovie'", AppCompatEditText.class);
    target.mSearchMovieRv = Utils.findRequiredViewAsType(source, R.id.searchMoviesRv, "field 'mSearchMovieRv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPrgLoading = null;
    target.mEdtSearchMovie = null;
    target.mSearchMovieRv = null;
  }
}
