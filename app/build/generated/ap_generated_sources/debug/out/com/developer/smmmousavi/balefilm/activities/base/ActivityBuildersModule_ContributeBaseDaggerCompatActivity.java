package com.developer.smmmousavi.balefilm.activities.base;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuildersModule_ContributeBaseDaggerCompatActivity.BaseDaggerCompatActivitySubcomponent
          .class
)
public abstract class ActivityBuildersModule_ContributeBaseDaggerCompatActivity {
  private ActivityBuildersModule_ContributeBaseDaggerCompatActivity() {}

  @Binds
  @IntoMap
  @ClassKey(BaseDaggerCompatActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseDaggerCompatActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface BaseDaggerCompatActivitySubcomponent
      extends AndroidInjector<BaseDaggerCompatActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BaseDaggerCompatActivity> {}
  }
}
