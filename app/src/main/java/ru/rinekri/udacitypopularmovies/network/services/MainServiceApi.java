package ru.rinekri.udacitypopularmovies.network.services;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.rinekri.udacitypopularmovies.network.models.PagedResponse;

public interface MainServiceApi {
  @GET("movie/top_rated")
  Call<PagedResponse> getTopRatedMovies();

  @GET("movie/popular")
  Call<PagedResponse> getPopularMovies();
}