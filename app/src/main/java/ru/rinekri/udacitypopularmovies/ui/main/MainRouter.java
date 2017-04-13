package ru.rinekri.udacitypopularmovies.ui.main;

import android.content.Context;
import android.view.View;

import ru.rinekri.udacitypopularmovies.ui.details.DetailsActivity;
import ru.rinekri.udacitypopularmovies.ui.details.MovieShortInfo;
import ru.rinekri.udacitypopularmovies.ui.utils.ViewUtils;

public class MainRouter {
  private Context context;
  private View messageView;

  public MainRouter(Context context, View messageView) {
    this.context = context;
    this.messageView = messageView;
  }

  public void showDetailInfo(MovieShortInfo movieInfo) {
    DetailsActivity.start(context, movieInfo);
  }

  public void showMessage(String text) {
    ViewUtils.showSnack(messageView, text);
  }
}