package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.setting.SettingFragment;
import com.developer.smmmousavi.balefilm.fragments.setting.di.SettingFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.setting.di.SettingFragmentVMModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentsBuilderModule_ContributeSettingDaggerFragment.SettingFragmentSubcomponent.class
)
public abstract class FragmentsBuilderModule_ContributeSettingDaggerFragment {
  private FragmentsBuilderModule_ContributeSettingDaggerFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SettingFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SettingFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = {SettingFragmentModule.class, SettingFragmentVMModule.class})
  public interface SettingFragmentSubcomponent extends AndroidInjector<SettingFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SettingFragment> {}
  }
}
