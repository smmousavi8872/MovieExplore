package com.developer.smmmousavi.balefilm.ui.activities.base;

import com.developer.smmmousavi.balefilm.ui.activities.drawer.BaseDrawerActivity;
import com.developer.smmmousavi.balefilm.ui.activities.drawer.di.BaseDrawerActivityModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuildersModule_ContributeBaseDrawerActivity.BaseDrawerActivitySubcomponent.class
)
public abstract class ActivityBuildersModule_ContributeBaseDrawerActivity {
  private ActivityBuildersModule_ContributeBaseDrawerActivity() {}

  @Binds
  @IntoMap
  @ClassKey(BaseDrawerActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseDrawerActivitySubcomponent.Factory builder);

  @Subcomponent(modules = BaseDrawerActivityModule.class)
  public interface BaseDrawerActivitySubcomponent extends AndroidInjector<BaseDrawerActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BaseDrawerActivity> {}
  }
}
