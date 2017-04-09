package ru.rinekri.udacitypopularmovies.network.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class MovieInfo implements Parcelable {
  abstract Long id();
  @Json(name = "poster_path")
  abstract String posterPath();
  abstract Boolean adult();
  abstract String overview();
  @Json(name = "release_date")
  abstract String releaseDate();
  @Json(name = "genre_ids")
  abstract List<Integer> genreIds();
  @Json(name = "original_title")
  abstract String originalTitle();
  abstract String title();
  @Json(name = "original_language")
  abstract String originalLanguage();
  @Json(name = "backdrop_path")
  abstract String backdropPath();
  abstract String popularity();
  @Json(name = "vote_count")
  abstract String voteCount();
  abstract String video();
  @Json(name = "vote_average")
  abstract String voteAverage();

  public static JsonAdapter<MovieInfo> jsonAdapter(Moshi moshi) {
    return new AutoValue_MovieInfo.MoshiJsonAdapter(moshi);
  }
}