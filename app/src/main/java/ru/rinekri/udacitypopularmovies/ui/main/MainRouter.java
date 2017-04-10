package ru.rinekri.udacitypopularmovies.ui.main;

import android.content.Context;

import ru.rinekri.udacitypopularmovies.ui.details.DetailsActivity;
import ru.rinekri.udacitypopularmovies.ui.details.MovieShortInfo;

public class MainRouter {
  private Context context;

  public MainRouter(Context context) {
    this.context = context;
  }

  public void showDetailInfo(MovieShortInfo movieInfo) {
    DetailsActivity.start(context, movieInfo);
  }
}