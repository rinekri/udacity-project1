package ru.rinekri.udacitypopularmovies.ui.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

public class ViewUtils {
  public static void showSnackMessage(View targetView, String message) {
    Snackbar.make(targetView, message, Snackbar.LENGTH_LONG).show();
  }
}
