package ru.rinekri.udacitypopularmovies;

import android.app.Application;

import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application {

  public ApplicationComponent appComponent;

  @Override
  public void onCreate() {
    setupLogs();
    setupCalligraphy();
    setupAppCompnent();
    super.onCreate();
  }

  private void setupAppCompnent() {
    appComponent = DaggerApplicationComponent.builder()
      .applicationModule(new ApplicationModule(this))
      .build();
  }

  private void setupCalligraphy() {
    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
      .setDefaultFontPath("fonts/Roboto-Regular.ttf")
      .setFontAttrId(R.attr.fontPath)
      .build());
  }

  private void setupLogs() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}