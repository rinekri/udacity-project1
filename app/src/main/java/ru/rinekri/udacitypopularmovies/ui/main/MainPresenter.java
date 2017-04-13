package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;

import java.util.Arrays;
import java.util.List;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpPresenter;
import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;
import ru.rinekri.udacitypopularmovies.ui.base.SyncInteractor;
import ru.rinekri.udacitypopularmovies.ui.details.MovieShortInfo;

@InjectViewState
public class MainPresenter extends BaseMvpPresenter<MainPM, MainView> {
  private static final List<MovieSortType> SORT_TYPES = Arrays.asList(MovieSortType.values());
  private static final MovieSortType INIT_SORT_TYPE = MovieSortType.Popular;

  @Nullable
  private MainRouter router;
  private SyncInteractor<MovieSortType, MainPM> interactor;

  public MainPresenter(SyncInteractor<MovieSortType, MainPM> interactor) {
    this.interactor = interactor;
  }

  void setRouter(@NonNull MainRouter router) {
    this.router = router;
  }

  @Override
  protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    showInitContent(INIT_SORT_TYPE);
    loadViewContent(INIT_SORT_TYPE);
  }

  @Override
  public void onDestroy() {
    router = null;
    super.onDestroy();
  }

  public void onMoviePosterClicked(MovieInfo movieInfo) {
    router.showDetailInfo(MovieShortInfo.from(movieInfo));
  }

  public void onMoviePosterLongClicked(MovieInfo movieInfo) {
    router.showMessage(movieInfo.originalTitle());
  }

  public void onMovieSortChanged(MovieSortType sortType) {
    showInitContent(sortType);
    loadViewContent(sortType);
  }

  private void loadViewContent(MovieSortType sortType) {
    abortNetworkRequests();
    elceNetworkRequest(() -> interactor.getData(sortType));
  }

  private void showInitContent(MovieSortType sortType) {
    getViewState().showInitContent(new AutoValue_MainIM(SORT_TYPES, sortType));
  }
}