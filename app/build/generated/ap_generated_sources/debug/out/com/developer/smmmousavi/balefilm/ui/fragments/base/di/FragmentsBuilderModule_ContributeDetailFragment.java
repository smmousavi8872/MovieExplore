package com.developer.smmmousavi.balefilm.ui.fragments.base.di;

import com.developer.smmmousavi.balefilm.ui.fragments.detail.DetailFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.di.DetailFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.detail.di.DetailFragmentVMModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentsBuilderModule_ContributeDetailFragment.DetailFragmentSubcomponent.class
)
public abstract class FragmentsBuilderModule_ContributeDetailFragment {
  private FragmentsBuilderModule_ContributeDetailFragment() {}

  @Binds
  @IntoMap
  @ClassKey(DetailFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DetailFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = {DetailFragmentModule.class, DetailFragmentVMModule.class})
  public interface DetailFragmentSubcomponent extends AndroidInjector<DetailFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DetailFragment> {}
  }
}
