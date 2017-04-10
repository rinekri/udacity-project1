package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.services.MainServiceApi;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;
import ru.rinekri.udacitypopularmovies.ui.utils.ContextUtils;
import ru.rinekri.udacitypopularmovies.ui.utils.ViewUtils;

import static ru.rinekri.udacitypopularmovies.ui.UiConstants.GRID_COLUMNS;

public class MainActivity extends BaseMvpActivity<MainPM> implements MainView {

  @BindView(R.id.main_content_view)
  RecyclerView contentView;

  MainAdapter contentAdapter;

  @InjectPresenter
  public MainPresenter presenter;

  @ProvidePresenter
  public MainPresenter providePresenter() {
    MainRouter router = new MainRouter(this);
    MainServiceApi api = ContextUtils.appComponent(this).mainServiceApi();
    MainInputInteractor interactor = new MainInputInteractor(api);
    return new MainPresenter(router, interactor);
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentRes(R.layout.content_main)
      .titleRes(R.string.main_title)
      .build();
  }

  @Override
  protected void initView() {
    contentAdapter = new MainAdapter(
      R.layout.item_main,
      movieInfo -> presenter.onMoviePosterClicked(movieInfo),
      movieInfo -> presenter.onMoviePosterLongClicked(movieInfo)
    );
    contentView.setAdapter(contentAdapter);
    contentView.setLayoutManager(new GridLayoutManager(this, GRID_COLUMNS));
  }

  @Override
  public void showContent(MainPM data) {
    super.showContent(data);
    contentAdapter.swapContent(data.movies());
  }

  @Override
  public void showMessage(String text) {
    ViewUtils.showSnackMessage(contentView, text);
  }
}