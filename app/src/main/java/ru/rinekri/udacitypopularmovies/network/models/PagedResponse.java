package ru.rinekri.udacitypopularmovies.network.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class PagedResponse<D> {
  public abstract Integer page();
  public abstract List<D> results();
  @Json(name = "total_results")
  public abstract Long totalResults();
  @Json(name = "total_pages")
  public abstract Long totalPages();

  public static <D> JsonAdapter<PagedResponse<D>> jsonAdapter(Moshi moshi) {
    return new AutoValue_PagedResponse.MoshiJsonAdapter(moshi, new Class[] {Object.class});
  }
}