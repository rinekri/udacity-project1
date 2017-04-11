package ru.rinekri.udacitypopularmovies.ui.details;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
abstract public class DetailsPM implements Parcelable {
  abstract MovieShortInfo movieInfo();
}