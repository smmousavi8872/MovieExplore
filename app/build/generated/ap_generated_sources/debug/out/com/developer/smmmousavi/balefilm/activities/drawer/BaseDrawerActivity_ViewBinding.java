// Generated code from Butter Knife. Do not modify!
package com.developer.smmmousavi.balefilm.activities.drawer;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.developer.smmmousavi.balefilm.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseDrawerActivity_ViewBinding implements Unbinder {
  private BaseDrawerActivity target;

  private View view7f080094;

  @UiThread
  public BaseDrawerActivity_ViewBinding(BaseDrawerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BaseDrawerActivity_ViewBinding(final BaseDrawerActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgNavbarButton, "field 'imgNavbarButton' and method 'setNavBarListener'");
    target.imgNavbarButton = Utils.castView(view, R.id.imgNavbarButton, "field 'imgNavbarButton'", AppCompatImageView.class);
    view7f080094 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setNavBarListener();
      }
    });
    target.mNavigationView = Utils.findRequiredViewAsType(source, R.id.navbarView, "field 'mNavigationView'", NavigationView.class);
    target.mDrawerLayout = Utils.findRequiredViewAsType(source, R.id.dlMainFragmentDrawer, "field 'mDrawerLayout'", DrawerLayout.class);
    target.mToolbarLayout = Utils.findRequiredViewAsType(source, R.id.mainToolbar, "field 'mToolbarLayout'", AppBarLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BaseDrawerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgNavbarButton = null;
    target.mNavigationView = null;
    target.mDrawerLayout = null;
    target.mToolbarLayout = null;

    view7f080094.setOnClickListener(null);
    view7f080094 = null;
  }
}
