package com.developer.smmmousavi.balefilm.fragments.base.di;

import com.developer.smmmousavi.balefilm.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.fragments.search.di.SearchFragmentModule;
import com.developer.smmmousavi.balefilm.fragments.search.di.SearchFragmentVMModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent.class
)
public abstract class FragmentsBuilderModule_ContributeSearchFragment {
  private FragmentsBuilderModule_ContributeSearchFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SearchFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SearchFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = {SearchFragmentModule.class, SearchFragmentVMModule.class})
  public interface SearchFragmentSubcomponent extends AndroidInjector<SearchFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SearchFragment> {}
  }
}
