package ru.rinekri.udacitypopularmovies.network.interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.rinekri.udacitypopularmovies.BuildConfig;

public class ApiRequestInterceptor implements Interceptor {
  private static final String API_KEY_QUERY_PARAM = "api_key";

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request.Builder newRequestBuilder = chain.request().newBuilder();
    HttpUrl newUrl = chain.request().url().newBuilder()
      .addQueryParameter(API_KEY_QUERY_PARAM, BuildConfig.DB_MOVIE_API_KEY)
      .build();
    return chain.proceed(newRequestBuilder.url(newUrl).build());
  }
}