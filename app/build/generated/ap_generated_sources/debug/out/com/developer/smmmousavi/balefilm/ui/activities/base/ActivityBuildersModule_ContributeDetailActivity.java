package com.developer.smmmousavi.balefilm.ui.activities.base;

import com.developer.smmmousavi.balefilm.ui.activities.detail.DetailActivity;
import com.developer.smmmousavi.balefilm.ui.activities.detail.di.DetailActivityModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuildersModule_ContributeDetailActivity.DetailActivitySubcomponent.class
)
public abstract class ActivityBuildersModule_ContributeDetailActivity {
  private ActivityBuildersModule_ContributeDetailActivity() {}

  @Binds
  @IntoMap
  @ClassKey(DetailActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DetailActivitySubcomponent.Factory builder);

  @Subcomponent(modules = DetailActivityModule.class)
  public interface DetailActivitySubcomponent extends AndroidInjector<DetailActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DetailActivity> {}
  }
}
