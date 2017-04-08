package ru.rinekri.udacitypopularmovies.network.json_adapters;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

@MoshiAdapterFactory
public abstract class MoshiAutoValueAdapterFactory implements JsonAdapter.Factory {
  public static JsonAdapter.Factory create() {
    return new AutoValueMoshi_MoshiAutoValueAdapterFactory();
  }
}