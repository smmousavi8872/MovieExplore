package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.base.BaseDaggerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentsBuilderModule_ContributeBaseDaggerFragment.BaseDaggerFragmentSubcomponent.class
)
public abstract class FragmentsBuilderModule_ContributeBaseDaggerFragment {
  private FragmentsBuilderModule_ContributeBaseDaggerFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BaseDaggerFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseDaggerFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = {BaseFragmentModule.class, BaseFragmentVMModule.class})
  public interface BaseDaggerFragmentSubcomponent extends AndroidInjector<BaseDaggerFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BaseDaggerFragment> {}
  }
}
