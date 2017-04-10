package ru.rinekri.udacitypopularmovies.ui.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import ru.rinekri.udacitypopularmovies.ApplicationComponent;
import ru.rinekri.udacitypopularmovies.MyApplication;

public class ContextUtils {
  public static ApplicationComponent appComponent(Context context) {
    return ((MyApplication) context.getApplicationContext()).appComponent;
  }

  public static void showToastMessage(Context context, String message) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
  }

  public static void showSnackMessage(View targetView, String message) {
    Snackbar.make(targetView, message, Snackbar.LENGTH_LONG).show();
  }
}