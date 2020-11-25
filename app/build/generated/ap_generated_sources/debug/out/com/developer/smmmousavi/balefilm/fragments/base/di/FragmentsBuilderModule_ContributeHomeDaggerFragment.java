package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.fragments.home.di.HomeFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.home.di.HomeFragmentVMModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent.class
)
public abstract class FragmentsBuilderModule_ContributeHomeDaggerFragment {
  private FragmentsBuilderModule_ContributeHomeDaggerFragment() {}

  @Binds
  @IntoMap
  @ClassKey(HomeFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      HomeFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = {HomeFragmentModule.class, HomeFragmentVMModule.class})
  public interface HomeFragmentSubcomponent extends AndroidInjector<HomeFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<HomeFragment> {}
  }
}
