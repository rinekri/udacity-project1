package ru.rinekri.udacitypopularmovies.network;

import okhttp3.logging.HttpLoggingInterceptor;
import ru.rinekri.udacitypopularmovies.BuildConfig;

public class NetworkConstants {
  public static final Long DEFAULT_CONNECT_TIMEOUT = 10000L;
  public static HttpLoggingInterceptor.Level HTTP_LOG_LEVEL;
  public static String API_VERSION = "3";

  static {
    if (BuildConfig.DEBUG) {
      HTTP_LOG_LEVEL = HttpLoggingInterceptor.Level.BODY;
    } else {
      HTTP_LOG_LEVEL = HttpLoggingInterceptor.Level.NONE;
    }
  }
}