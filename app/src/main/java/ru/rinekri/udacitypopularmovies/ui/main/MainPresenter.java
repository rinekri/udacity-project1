package ru.rinekri.udacitypopularmovies.ui.main;

import com.arellomobile.mvp.InjectViewState;

import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpPresenter;
import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;
import ru.rinekri.udacitypopularmovies.ui.base.SyncInteractor;

@InjectViewState
public class MainPresenter extends BaseMvpPresenter<MainPM, MainView> {

  private MainRouter router;
  private SyncInteractor<MovieSortType, MainPM> interactor;

  public MainPresenter(MainRouter router,
                       SyncInteractor<MovieSortType, MainPM> interactor) {
    this.router = router;
    this.interactor = interactor;
  }

  @Override
  protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    elceNetworkRequest(() -> interactor.getData(MovieSortType.Popular));
  }

  public void onMoviePosterClicked(MovieInfo movieInfo) {
    router.showDetailInfo(movieInfo);
  }
}