package ru.rinekri.udacitypopularmovies.network.services;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.rinekri.udacitypopularmovies.network.models.Foo;

public interface MainServiceApi {
  @GET("")
  Call<Foo> getMovies();
}