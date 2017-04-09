package ru.rinekri.udacitypopularmovies.ui.main;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import java.util.List;
import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;

@AutoValue
abstract public class MainPM implements Parcelable {
  abstract List<MovieInfo> movies();
}