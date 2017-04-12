package ru.rinekri.udacitypopularmovies.ui.main;

import com.arellomobile.mvp.InjectViewState;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpPresenter;
import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;
import ru.rinekri.udacitypopularmovies.ui.base.SyncInteractor;
import ru.rinekri.udacitypopularmovies.ui.details.MovieShortInfo;

@InjectViewState
public class MainPresenter extends BaseMvpPresenter<MainPM, MainView> {

  private MainRouter router;
  private SyncInteractor<MovieSortType, MainPM> interactor;

  public MainPresenter(SyncInteractor<MovieSortType, MainPM> interactor) {
    this.interactor = interactor;
  }

  void setRouter(MainRouter router) {
    this.router = router;
  }

  @Override
  protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    loadContent(MovieSortType.Popular);
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
    getViewState().showMessage(movieInfo.originalTitle());
  }

  public void onMovieShortChanged(MovieSortType sortType) {
    loadContent(sortType);
  }

  private void loadContent(MovieSortType sortType) {
    abortNetworkRequests();
    elceNetworkRequest(() -> interactor.getData(sortType));
  }
}