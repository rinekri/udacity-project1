package ru.rinekri.udacitypopularmovies.ui.main;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;

@AutoValue
abstract public class MainPM implements Parcelable {
  @Nullable
  abstract List<MovieInfo> movies();
}