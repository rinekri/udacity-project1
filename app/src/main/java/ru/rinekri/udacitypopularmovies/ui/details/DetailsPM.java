package ru.rinekri.udacitypopularmovies.ui.details;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;

@AutoValue
abstract public class DetailsPM implements Parcelable {
  abstract MovieInfo movieInfo();
}