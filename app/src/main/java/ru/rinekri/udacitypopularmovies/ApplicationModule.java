package ru.rinekri.udacitypopularmovies;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ru.rinekri.udacitypopularmovies.annotations.ApplicationScope;

@Module
public class ApplicationModule {

  private Context context;

  public ApplicationModule(Context context) {
    this.context = context;
  }

  @Provides
  @ApplicationScope
  public Context provideContext() {
    return context;
  }
}