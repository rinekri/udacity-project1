package ru.rinekri.udacitypopularmovies.ui.details;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpPresenter;

@InjectViewState
public class DetailsPresenter extends BaseMvpPresenter<DetailsPM, DetailsView> {
  @NonNull
  private MovieShortInfo mMovieShortInfo;

  public DetailsPresenter(@NonNull MovieShortInfo movieShortInfo) {
    mMovieShortInfo = movieShortInfo;
  }

  @Override
  protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }
}