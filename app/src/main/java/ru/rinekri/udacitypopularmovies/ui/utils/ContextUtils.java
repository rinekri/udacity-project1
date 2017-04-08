package ru.rinekri.udacitypopularmovies.ui.utils;

import android.content.Context;

import ru.rinekri.udacitypopularmovies.ApplicationComponent;
import ru.rinekri.udacitypopularmovies.MyApplication;

public class ContextUtils {
  public static ApplicationComponent appComponent(Context context) {
    return ((MyApplication) context.getApplicationContext()).appComponent;
  }
}