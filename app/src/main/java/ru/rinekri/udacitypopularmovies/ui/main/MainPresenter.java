package ru.rinekri.udacitypopularmovies.ui.main;

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
  private final List<MovieSortType> sortTypes = Arrays.asList(MovieSortType.values());
  private final MovieSortType initSortType = MovieSortType.Popular;

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
    initContent(initSortType);
    loadContent(initSortType);
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
    initContent(sortType);
    loadContent(sortType);
  }

  private void loadContent(MovieSortType sortType) {
    abortNetworkRequests();
    elceNetworkRequest(() -> interactor.getData(sortType));
  }

  private void initContent(MovieSortType sortType) {
    getViewState().showInitContent(new AutoValue_MainIM(sortTypes, sortType));
  }
}