package ru.rinekri.udacitypopularmovies.network.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;

import java.util.List;

@AutoValue
public abstract class PagedResponse {
  public abstract Integer page();
  public abstract List<Foo> results();
  @Json(name = "total_results")
  public abstract Long totalResults();
  @Json(name = "total_pages")
  public abstract Long totalPages();
}