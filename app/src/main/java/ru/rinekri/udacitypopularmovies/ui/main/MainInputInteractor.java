package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.annotation.NonNull;

import java.util.List;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.network.services.MainServiceApi;
import ru.rinekri.udacitypopularmovies.ui.base.SyncInteractor;

public class MainInputInteractor implements SyncInteractor<MovieSortType, List<MovieInfo>> {

  private MainServiceApi mMainServiceApi;

  public MainInputInteractor(MainServiceApi mainServiceApi) {
    mMainServiceApi = mainServiceApi;
  }

  @Override
  public List<MovieInfo> getData(@NonNull MovieSortType type) throws Exception {
    switch (type) {
      case TopRated:
        return mMainServiceApi.getTopRatedMovies().execute().body().results();
      case Popular:
        return mMainServiceApi.getPopularMovies().execute().body().results();
    }
    throw new UnsupportedOperationException("expected " + type + " doens't support");
  }
}