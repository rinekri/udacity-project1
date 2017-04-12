package ru.rinekri.udacitypopularmovies.ui.main;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;

@AutoValue
abstract public class MainIM implements Parcelable {
  abstract List<MovieSortType> sortTypes();
  abstract MovieSortType initSortType();
}