package ru.rinekri.udacitypopularmovies.network.services;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;

public interface MainServiceApi {
  @GET("movie/top_rated")
  Call<MovieInfo> getTopRelatedMovies();

  @GET("movie/popular")
  Call<MovieInfo> getPopularMovies();
}