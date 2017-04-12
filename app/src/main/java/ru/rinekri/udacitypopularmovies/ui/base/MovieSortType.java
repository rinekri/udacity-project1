package ru.rinekri.udacitypopularmovies.ui.base;

import android.support.annotation.StringRes;

import ru.rinekri.udacitypopularmovies.R;

public enum MovieSortType {
  Popular(R.string.main_sort_popular_movies),
  TopRated(R.string.main_sort_top_rated_movies);

  MovieSortType(@StringRes Integer nameRes) {
    this.nameRes = nameRes;
  }

  private Integer nameRes;

  public Integer getNameRes() {
    return nameRes;
  }
}