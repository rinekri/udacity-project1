package ru.rinekri.udacitypopularmovies.network.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Foo implements Parcelable {
  abstract String bar();
  @Json(name = "Baz")
  abstract String baz();

  public static JsonAdapter<Foo> jsonAdapter(Moshi moshi) {
    return new AutoValue_Foo.MoshiJsonAdapter(moshi);
  }
}