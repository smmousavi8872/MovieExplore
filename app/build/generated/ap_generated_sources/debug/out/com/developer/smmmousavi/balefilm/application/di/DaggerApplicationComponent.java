// Generated by Dagger (https://google.github.io/dagger).
package com.developer.smmmousavi.balefilm.application.di;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import androidx.lifecycle.ViewModel;
import com.developer.smmmousavi.balefilm.application.BaseApplication;
import com.developer.smmmousavi.balefilm.factory.viewmodel.ViewModelProviderFactory;
import com.developer.smmmousavi.balefilm.repository.FilteredMovieRepository;
import com.developer.smmmousavi.balefilm.repository.GenreRepository;
import com.developer.smmmousavi.balefilm.repository.SearchMovieRepository;
import com.developer.smmmousavi.balefilm.ui.activities.base.ActivityBuildersModule_ContributeBaseDaggerCompatActivity;
import com.developer.smmmousavi.balefilm.ui.activities.base.ActivityBuildersModule_ContributeBaseDrawerActivity;
import com.developer.smmmousavi.balefilm.ui.activities.base.ActivityBuildersModule_ContributeMainActivity;
import com.developer.smmmousavi.balefilm.ui.activities.base.ActivityBuildersModule_ContributeSingleFragmentActivity;
import com.developer.smmmousavi.balefilm.ui.activities.base.BaseDaggerCompatActivity;
import com.developer.smmmousavi.balefilm.ui.activities.drawer.BaseDrawerActivity;
import com.developer.smmmousavi.balefilm.ui.activities.main.MainActivity;
import com.developer.smmmousavi.balefilm.ui.activities.singlefragment.SingleFragmentActivity;
import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.base.di.FragmentsBuilderModule_ContributeBaseDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.base.di.FragmentsBuilderModule_ContributeHomeDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.base.di.FragmentsBuilderModule_ContributeSearchFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.base.di.FragmentsBuilderModule_ContributeSettingDaggerFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragmentViewModel;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragmentViewModel_Factory;
import com.developer.smmmousavi.balefilm.ui.fragments.home.HomeFragment_MembersInjector;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentModule_ProvideGenreRepositoryFactory;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentModule_ProvideMovieRepositoryFactory;
import com.developer.smmmousavi.balefilm.ui.fragments.home.di.HomeFragmentModule_ProvideRecyclerViewHelperFactory;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragment;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragmentViewModel;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragmentViewModel_Factory;
import com.developer.smmmousavi.balefilm.ui.fragments.search.SearchFragment_MembersInjector;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentModule;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentModule_ProvideRecyclerViewHelperFactory;
import com.developer.smmmousavi.balefilm.ui.fragments.search.di.SearchFragmentModule_ProvideSearchMovieRepositoryFactory;
import com.developer.smmmousavi.balefilm.ui.fragments.setting.SettingFragment;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<
          ActivityBuildersModule_ContributeBaseDaggerCompatActivity
              .BaseDaggerCompatActivitySubcomponent.Factory>
      baseDaggerCompatActivitySubcomponentFactoryProvider;

  private Provider<
          ActivityBuildersModule_ContributeBaseDrawerActivity.BaseDrawerActivitySubcomponent
              .Factory>
      baseDrawerActivitySubcomponentFactoryProvider;

  private Provider<
          ActivityBuildersModule_ContributeSingleFragmentActivity.SingleFragmentActivitySubcomponent
              .Factory>
      singleFragmentActivitySubcomponentFactoryProvider;

  private Provider<ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory>
      mainActivitySubcomponentFactoryProvider;

  private Provider<
          FragmentsBuilderModule_ContributeBaseDaggerFragment.BaseDaggerFragmentSubcomponent
              .Factory>
      baseDaggerFragmentSubcomponentFactoryProvider;

  private Provider<
          FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent.Factory>
      homeFragmentSubcomponentFactoryProvider;

  private Provider<
          FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent.Factory>
      searchFragmentSubcomponentFactoryProvider;

  private Provider<
          FragmentsBuilderModule_ContributeSettingDaggerFragment.SettingFragmentSubcomponent
              .Factory>
      settingFragmentSubcomponentFactoryProvider;

  private Provider<Application> applicationProvider;

  private DaggerApplicationComponent(Application applicationParam) {

    initialize(applicationParam);
  }

  public static ApplicationComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>>
      getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
    return MapBuilder.<Class<?>, Provider<AndroidInjector.Factory<?>>>newMapBuilder(8)
        .put(
            BaseDaggerCompatActivity.class,
            (Provider) baseDaggerCompatActivitySubcomponentFactoryProvider)
        .put(BaseDrawerActivity.class, (Provider) baseDrawerActivitySubcomponentFactoryProvider)
        .put(
            SingleFragmentActivity.class,
            (Provider) singleFragmentActivitySubcomponentFactoryProvider)
        .put(MainActivity.class, (Provider) mainActivitySubcomponentFactoryProvider)
        .put(BaseDaggerFragment.class, (Provider) baseDaggerFragmentSubcomponentFactoryProvider)
        .put(HomeFragment.class, (Provider) homeFragmentSubcomponentFactoryProvider)
        .put(SearchFragment.class, (Provider) searchFragmentSubcomponentFactoryProvider)
        .put(SettingFragment.class, (Provider) settingFragmentSubcomponentFactoryProvider)
        .build();
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  private DispatchingAndroidInjector<BroadcastReceiver>
      getDispatchingAndroidInjectorOfBroadcastReceiver() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  private DispatchingAndroidInjector<Service> getDispatchingAndroidInjectorOfService() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  private DispatchingAndroidInjector<ContentProvider>
      getDispatchingAndroidInjectorOfContentProvider() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Application applicationParam) {
    this.baseDaggerCompatActivitySubcomponentFactoryProvider =
        new Provider<
            ActivityBuildersModule_ContributeBaseDaggerCompatActivity
                .BaseDaggerCompatActivitySubcomponent.Factory>() {
          @Override
          public ActivityBuildersModule_ContributeBaseDaggerCompatActivity
                  .BaseDaggerCompatActivitySubcomponent.Factory
              get() {
            return new BaseDaggerCompatActivitySubcomponentFactory();
          }
        };
    this.baseDrawerActivitySubcomponentFactoryProvider =
        new Provider<
            ActivityBuildersModule_ContributeBaseDrawerActivity.BaseDrawerActivitySubcomponent
                .Factory>() {
          @Override
          public ActivityBuildersModule_ContributeBaseDrawerActivity.BaseDrawerActivitySubcomponent
                  .Factory
              get() {
            return new BaseDrawerActivitySubcomponentFactory();
          }
        };
    this.singleFragmentActivitySubcomponentFactoryProvider =
        new Provider<
            ActivityBuildersModule_ContributeSingleFragmentActivity
                .SingleFragmentActivitySubcomponent.Factory>() {
          @Override
          public ActivityBuildersModule_ContributeSingleFragmentActivity
                  .SingleFragmentActivitySubcomponent.Factory
              get() {
            return new SingleFragmentActivitySubcomponentFactory();
          }
        };
    this.mainActivitySubcomponentFactoryProvider =
        new Provider<
            ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory>() {
          @Override
          public ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory
              get() {
            return new MainActivitySubcomponentFactory();
          }
        };
    this.baseDaggerFragmentSubcomponentFactoryProvider =
        new Provider<
            FragmentsBuilderModule_ContributeBaseDaggerFragment.BaseDaggerFragmentSubcomponent
                .Factory>() {
          @Override
          public FragmentsBuilderModule_ContributeBaseDaggerFragment.BaseDaggerFragmentSubcomponent
                  .Factory
              get() {
            return new BaseDaggerFragmentSubcomponentFactory();
          }
        };
    this.homeFragmentSubcomponentFactoryProvider =
        new Provider<
            FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent
                .Factory>() {
          @Override
          public FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent
                  .Factory
              get() {
            return new HomeFragmentSubcomponentFactory();
          }
        };
    this.searchFragmentSubcomponentFactoryProvider =
        new Provider<
            FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent.Factory>() {
          @Override
          public FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent.Factory
              get() {
            return new SearchFragmentSubcomponentFactory();
          }
        };
    this.settingFragmentSubcomponentFactoryProvider =
        new Provider<
            FragmentsBuilderModule_ContributeSettingDaggerFragment.SettingFragmentSubcomponent
                .Factory>() {
          @Override
          public FragmentsBuilderModule_ContributeSettingDaggerFragment.SettingFragmentSubcomponent
                  .Factory
              get() {
            return new SettingFragmentSubcomponentFactory();
          }
        };
    this.applicationProvider = InstanceFactory.create(applicationParam);
  }

  @Override
  public void inject(BaseApplication arg0) {
    injectBaseApplication(arg0);
  }

  private BaseApplication injectBaseApplication(BaseApplication instance) {
    DaggerApplication_MembersInjector.injectActivityInjector(
        instance, getDispatchingAndroidInjectorOfActivity());
    DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(
        instance, getDispatchingAndroidInjectorOfBroadcastReceiver());
    DaggerApplication_MembersInjector.injectFragmentInjector(
        instance, getDispatchingAndroidInjectorOfFragment());
    DaggerApplication_MembersInjector.injectServiceInjector(
        instance, getDispatchingAndroidInjectorOfService());
    DaggerApplication_MembersInjector.injectContentProviderInjector(
        instance, getDispatchingAndroidInjectorOfContentProvider());
    DaggerApplication_MembersInjector.injectSetInjected(instance);
    return instance;
  }

  private static final class Builder implements ApplicationComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public ApplicationComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerApplicationComponent(application);
    }
  }

  private final class BaseDaggerCompatActivitySubcomponentFactory
      implements ActivityBuildersModule_ContributeBaseDaggerCompatActivity
          .BaseDaggerCompatActivitySubcomponent.Factory {
    @Override
    public ActivityBuildersModule_ContributeBaseDaggerCompatActivity
            .BaseDaggerCompatActivitySubcomponent
        create(BaseDaggerCompatActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new BaseDaggerCompatActivitySubcomponentImpl(arg0);
    }
  }

  private final class BaseDaggerCompatActivitySubcomponentImpl
      implements ActivityBuildersModule_ContributeBaseDaggerCompatActivity
          .BaseDaggerCompatActivitySubcomponent {
    private BaseDaggerCompatActivitySubcomponentImpl(BaseDaggerCompatActivity arg0) {}

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(BaseDaggerCompatActivity arg0) {
      injectBaseDaggerCompatActivity(arg0);
    }

    private BaseDaggerCompatActivity injectBaseDaggerCompatActivity(
        BaseDaggerCompatActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
          instance, DaggerApplicationComponent.this.getDispatchingAndroidInjectorOfFragment());
      return instance;
    }
  }

  private final class BaseDrawerActivitySubcomponentFactory
      implements ActivityBuildersModule_ContributeBaseDrawerActivity.BaseDrawerActivitySubcomponent
          .Factory {
    @Override
    public ActivityBuildersModule_ContributeBaseDrawerActivity.BaseDrawerActivitySubcomponent
        create(BaseDrawerActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new BaseDrawerActivitySubcomponentImpl(arg0);
    }
  }

  private final class BaseDrawerActivitySubcomponentImpl
      implements ActivityBuildersModule_ContributeBaseDrawerActivity
          .BaseDrawerActivitySubcomponent {
    private BaseDrawerActivitySubcomponentImpl(BaseDrawerActivity arg0) {}

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(BaseDrawerActivity arg0) {
      injectBaseDrawerActivity(arg0);
    }

    private BaseDrawerActivity injectBaseDrawerActivity(BaseDrawerActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
          instance, DaggerApplicationComponent.this.getDispatchingAndroidInjectorOfFragment());
      return instance;
    }
  }

  private final class SingleFragmentActivitySubcomponentFactory
      implements ActivityBuildersModule_ContributeSingleFragmentActivity
          .SingleFragmentActivitySubcomponent.Factory {
    @Override
    public ActivityBuildersModule_ContributeSingleFragmentActivity
            .SingleFragmentActivitySubcomponent
        create(SingleFragmentActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new SingleFragmentActivitySubcomponentImpl(arg0);
    }
  }

  private final class SingleFragmentActivitySubcomponentImpl
      implements ActivityBuildersModule_ContributeSingleFragmentActivity
          .SingleFragmentActivitySubcomponent {
    private SingleFragmentActivitySubcomponentImpl(SingleFragmentActivity arg0) {}

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(SingleFragmentActivity arg0) {
      injectSingleFragmentActivity(arg0);
    }

    private SingleFragmentActivity injectSingleFragmentActivity(SingleFragmentActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
          instance, DaggerApplicationComponent.this.getDispatchingAndroidInjectorOfFragment());
      return instance;
    }
  }

  private final class MainActivitySubcomponentFactory
      implements ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.Factory {
    @Override
    public ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent create(
        MainActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new MainActivitySubcomponentImpl(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl
      implements ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent {
    private MainActivitySubcomponentImpl(MainActivity arg0) {}

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);
    }

    private MainActivity injectMainActivity(MainActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
          instance, DaggerApplicationComponent.this.getDispatchingAndroidInjectorOfFragment());
      return instance;
    }
  }

  private final class BaseDaggerFragmentSubcomponentFactory
      implements FragmentsBuilderModule_ContributeBaseDaggerFragment.BaseDaggerFragmentSubcomponent
          .Factory {
    @Override
    public FragmentsBuilderModule_ContributeBaseDaggerFragment.BaseDaggerFragmentSubcomponent
        create(BaseDaggerFragment arg0) {
      Preconditions.checkNotNull(arg0);
      return new BaseDaggerFragmentSubcomponentImpl(arg0);
    }
  }

  private final class BaseDaggerFragmentSubcomponentImpl
      implements FragmentsBuilderModule_ContributeBaseDaggerFragment
          .BaseDaggerFragmentSubcomponent {
    private BaseDaggerFragmentSubcomponentImpl(BaseDaggerFragment arg0) {}

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(BaseDaggerFragment arg0) {
      injectBaseDaggerFragment(arg0);
    }

    private BaseDaggerFragment injectBaseDaggerFragment(BaseDaggerFragment instance) {
      DaggerFragment_MembersInjector.injectChildFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      return instance;
    }
  }

  private final class HomeFragmentSubcomponentFactory
      implements FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent
          .Factory {
    @Override
    public FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent create(
        HomeFragment arg0) {
      Preconditions.checkNotNull(arg0);
      return new HomeFragmentSubcomponentImpl(new HomeFragmentModule(), arg0);
    }
  }

  private final class HomeFragmentSubcomponentImpl
      implements FragmentsBuilderModule_ContributeHomeDaggerFragment.HomeFragmentSubcomponent {
    private final HomeFragmentModule homeFragmentModule;

    private Provider<FilteredMovieRepository> provideMovieRepositoryProvider;

    private Provider<GenreRepository> provideGenreRepositoryProvider;

    private Provider<HomeFragmentViewModel> homeFragmentViewModelProvider;

    private HomeFragmentSubcomponentImpl(
        HomeFragmentModule homeFragmentModuleParam, HomeFragment arg0) {
      this.homeFragmentModule = homeFragmentModuleParam;
      initialize(homeFragmentModuleParam, arg0);
    }

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    private Map<Class<? extends ViewModel>, Provider<ViewModel>>
        getMapOfClassOfAndProviderOfViewModel() {
      return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(
          HomeFragmentViewModel.class, (Provider) homeFragmentViewModelProvider);
    }

    private ViewModelProviderFactory getViewModelProviderFactory() {
      return new ViewModelProviderFactory(getMapOfClassOfAndProviderOfViewModel());
    }

    @SuppressWarnings("unchecked")
    private void initialize(
        final HomeFragmentModule homeFragmentModuleParam, final HomeFragment arg0) {
      this.provideMovieRepositoryProvider =
          HomeFragmentModule_ProvideMovieRepositoryFactory.create(homeFragmentModuleParam);
      this.provideGenreRepositoryProvider =
          HomeFragmentModule_ProvideGenreRepositoryFactory.create(homeFragmentModuleParam);
      this.homeFragmentViewModelProvider =
          HomeFragmentViewModel_Factory.create(
              DaggerApplicationComponent.this.applicationProvider,
              provideMovieRepositoryProvider,
              provideGenreRepositoryProvider);
    }

    @Override
    public void inject(HomeFragment arg0) {
      injectHomeFragment(arg0);
    }

    private HomeFragment injectHomeFragment(HomeFragment instance) {
      DaggerFragment_MembersInjector.injectChildFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      HomeFragment_MembersInjector.injectMProviderFactory(instance, getViewModelProviderFactory());
      HomeFragment_MembersInjector.injectMRvHelper(
          instance,
          HomeFragmentModule_ProvideRecyclerViewHelperFactory.provideRecyclerViewHelper(
              homeFragmentModule));
      return instance;
    }
  }

  private final class SearchFragmentSubcomponentFactory
      implements FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent
          .Factory {
    @Override
    public FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent create(
        SearchFragment arg0) {
      Preconditions.checkNotNull(arg0);
      return new SearchFragmentSubcomponentImpl(new SearchFragmentModule(), arg0);
    }
  }

  private final class SearchFragmentSubcomponentImpl
      implements FragmentsBuilderModule_ContributeSearchFragment.SearchFragmentSubcomponent {
    private final SearchFragmentModule searchFragmentModule;

    private Provider<SearchMovieRepository> provideSearchMovieRepositoryProvider;

    private Provider<SearchFragmentViewModel> searchFragmentViewModelProvider;

    private SearchFragmentSubcomponentImpl(
        SearchFragmentModule searchFragmentModuleParam, SearchFragment arg0) {
      this.searchFragmentModule = searchFragmentModuleParam;
      initialize(searchFragmentModuleParam, arg0);
    }

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    private Map<Class<? extends ViewModel>, Provider<ViewModel>>
        getMapOfClassOfAndProviderOfViewModel() {
      return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(
          SearchFragmentViewModel.class, (Provider) searchFragmentViewModelProvider);
    }

    private ViewModelProviderFactory getViewModelProviderFactory() {
      return new ViewModelProviderFactory(getMapOfClassOfAndProviderOfViewModel());
    }

    @SuppressWarnings("unchecked")
    private void initialize(
        final SearchFragmentModule searchFragmentModuleParam, final SearchFragment arg0) {
      this.provideSearchMovieRepositoryProvider =
          SearchFragmentModule_ProvideSearchMovieRepositoryFactory.create(
              searchFragmentModuleParam);
      this.searchFragmentViewModelProvider =
          SearchFragmentViewModel_Factory.create(
              DaggerApplicationComponent.this.applicationProvider,
              provideSearchMovieRepositoryProvider);
    }

    @Override
    public void inject(SearchFragment arg0) {
      injectSearchFragment(arg0);
    }

    private SearchFragment injectSearchFragment(SearchFragment instance) {
      DaggerFragment_MembersInjector.injectChildFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      SearchFragment_MembersInjector.injectMProviderFactory(
          instance, getViewModelProviderFactory());
      SearchFragment_MembersInjector.injectMRvHelper(
          instance,
          SearchFragmentModule_ProvideRecyclerViewHelperFactory.provideRecyclerViewHelper(
              searchFragmentModule));
      return instance;
    }
  }

  private final class SettingFragmentSubcomponentFactory
      implements FragmentsBuilderModule_ContributeSettingDaggerFragment.SettingFragmentSubcomponent
          .Factory {
    @Override
    public FragmentsBuilderModule_ContributeSettingDaggerFragment.SettingFragmentSubcomponent
        create(SettingFragment arg0) {
      Preconditions.checkNotNull(arg0);
      return new SettingFragmentSubcomponentImpl(arg0);
    }
  }

  private final class SettingFragmentSubcomponentImpl
      implements FragmentsBuilderModule_ContributeSettingDaggerFragment
          .SettingFragmentSubcomponent {
    private SettingFragmentSubcomponentImpl(SettingFragment arg0) {}

    private DispatchingAndroidInjector<androidx.fragment.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerApplicationComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(SettingFragment arg0) {
      injectSettingFragment(arg0);
    }

    private SettingFragment injectSettingFragment(SettingFragment instance) {
      DaggerFragment_MembersInjector.injectChildFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      return instance;
    }
  }
}
