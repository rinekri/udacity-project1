package ru.rinekri.udacitypopularmovies.ui.main;

import android.content.Context;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.utils.ContextUtils;

public class MainRouter {
  private Context context;

  public MainRouter(Context context) {
    this.context = context;
  }

  public void showDetailInfo(MovieInfo movieInfo) {
    ContextUtils.showMessage(context, "TODO: showDetailInfo");
  }
}