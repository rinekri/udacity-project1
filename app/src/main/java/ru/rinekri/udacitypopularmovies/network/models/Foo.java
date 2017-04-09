package ru.rinekri.udacitypopularmovies.network.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;

@AutoValue
public abstract class Foo implements Parcelable {
  abstract String bar();
  @Json(name = "Baz")
  abstract String baz();
}