package ru.rinekri.udacitypopularmovies.network.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

//TODO: Fix JsonAdapter for model with generic
@AutoValue
public abstract class PagedResponse {
  public abstract Integer page();
  public abstract List<MovieInfo> results();
  @Json(name = "total_results")
  public abstract Long totalResults();
  @Json(name = "total_pages")
  public abstract Long totalPages();

  public static JsonAdapter<PagedResponse> jsonAdapter(Moshi moshi) {
    return new AutoValue_PagedResponse.MoshiJsonAdapter(moshi);
  }
}