package ru.rinekri.udacitypopularmovies.ui.main;

import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.util.List;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;

@AutoValue
abstract public class MainPM implements Parcelable {
  @NonNull
  abstract List<MovieInfo> movies();

  public static MainPM create(@NonNull List<MovieInfo> movies) {
    return new AutoValue_MainPM(movies);
  }
}