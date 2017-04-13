package ru.rinekri.udacitypopularmovies.ui.base.models;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NetworkRequestWrapper<D> {
  @Nullable
  public abstract D data();
  @Nullable
  public abstract Throwable error();

  public static <D> NetworkRequestWrapper create(@Nullable D data,
                                                 @Nullable Throwable error) {
    return new AutoValue_NetworkRequestWrapper<D>(data, error);
  }
}