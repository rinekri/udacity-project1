package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;

import static ru.rinekri.udacitypopularmovies.ui.UiConstants.GRID_COLUMNS;

public class MainActivity extends BaseMvpActivity<MainPM> implements MainView {
  @BindView(R.id.main_content_view)
  RecyclerView contentView;

  MainAdapter<MovieInfo> contentAdapter;

  @InjectPresenter
  public MainPresenter presenter;

  @ProvidePresenter
  public MainPresenter providePresenter() {
    return new MainPresenter();
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentRes(R.layout.content_main)
      .titleRes(R.string.app_name)
      .build();
  }

  @Override
  protected void initView() {
    contentAdapter = new MainAdapter<>();
    contentView.setAdapter(contentAdapter);
    RecyclerView.LayoutManager manager = new GridLayoutManager(this, GRID_COLUMNS);
    contentView.setLayoutManager(manager);
  }

  @Override
  public void showContent(MainPM data) {
    super.showContent(data);
    contentAdapter.swapContent(data.movies());
  }
}