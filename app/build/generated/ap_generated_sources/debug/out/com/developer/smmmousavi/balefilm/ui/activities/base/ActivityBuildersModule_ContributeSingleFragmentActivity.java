package com.developer.smmmousavi.balefilm.ui.activities.base;

import com.developer.smmmousavi.balefilm.ui.activities.singlefragment.SingleFragmentActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuildersModule_ContributeSingleFragmentActivity.SingleFragmentActivitySubcomponent
          .class
)
public abstract class ActivityBuildersModule_ContributeSingleFragmentActivity {
  private ActivityBuildersModule_ContributeSingleFragmentActivity() {}

  @Binds
  @IntoMap
  @ClassKey(SingleFragmentActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SingleFragmentActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface SingleFragmentActivitySubcomponent
      extends AndroidInjector<SingleFragmentActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SingleFragmentActivity> {}
  }
}
