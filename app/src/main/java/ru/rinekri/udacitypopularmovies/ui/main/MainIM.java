package ru.rinekri.udacitypopularmovies.ui.main;

import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.util.List;

import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;

@AutoValue
abstract public class MainIM implements Parcelable {
  @NonNull
  abstract List<MovieSortType> sortTypes();
  @NonNull
  abstract MovieSortType initSortType();

  public static MainIM create(@NonNull List<MovieSortType> sortTypes,
                              MovieSortType initSortType) {
    return new AutoValue_MainIM(sortTypes, initSortType);
  }
}