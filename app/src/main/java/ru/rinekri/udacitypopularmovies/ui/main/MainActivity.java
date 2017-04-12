package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.Arrays;

import butterknife.BindArray;
import butterknife.BindView;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.services.MainServiceApi;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;
import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;
import ru.rinekri.udacitypopularmovies.ui.utils.ContextUtils;
import ru.rinekri.udacitypopularmovies.ui.utils.DialogUtils;
import ru.rinekri.udacitypopularmovies.ui.utils.ViewUtils;

import static ru.rinekri.udacitypopularmovies.ui.UiConstants.GRID_COLUMNS;

public class MainActivity extends BaseMvpActivity<MainPM> implements MainView {

  @BindView(R.id.content_container_view)
  RecyclerView contentView;
  @BindArray(R.array.main_sort_types)
  String[] sortTypes;

  TextView toolbarTitle;
  MainAdapter contentAdapter;

  @InjectPresenter
  public MainPresenter presenter;

  @ProvidePresenter
  public MainPresenter providePresenter() {
    MainServiceApi api = ContextUtils.appComponent(this).mainServiceApi();
    MainInputInteractor interactor = new MainInputInteractor(api);
    return new MainPresenter(interactor);
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.setRouter(new MainRouter(this));
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentViewRes(R.layout.content_main)
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
    toolbarTitle = (TextView) getLayoutInflater().inflate(R.layout.view_spinner, null);
    getToolbar().addView(toolbarTitle);
    //TODO: Transfer showing control to presenter
    toolbarTitle.setText(sortTypes[0]);
    toolbarTitle.setOnClickListener(view -> {
      DialogUtils.makePopupWindow(this, Arrays.asList(sortTypes), toolbarTitle, (position) -> {
        toolbarTitle.setText(sortTypes[position]);
        switch (position) {
          case 0:
            presenter.onMovieShortChanged(MovieSortType.Popular);
            break;
          case 1:
            presenter.onMovieShortChanged(MovieSortType.TopRated);
            break;
        }
      }).show();
    });
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