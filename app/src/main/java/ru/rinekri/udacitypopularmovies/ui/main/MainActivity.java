package ru.rinekri.udacitypopularmovies.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.services.MainServiceApi;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;
import ru.rinekri.udacitypopularmovies.ui.base.MovieSortType;
import ru.rinekri.udacitypopularmovies.ui.utils.ContextUtils;
import ru.rinekri.udacitypopularmovies.ui.utils.ViewUtils;

import static ru.rinekri.udacitypopularmovies.ui.UiConstants.GRID_COLUMNS;

public class MainActivity extends BaseMvpActivity<MainPM> implements MainView {

  @BindView(R.id.content_container_view)
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
    //TODO: Transfer ListPopUpWIndow creating logic to Utils and fix height of items
    String[] array = getResources().getStringArray(R.array.main_sort_types);
    View spinnerView = getLayoutInflater().inflate(R.layout.view_spinner, null);
    TextView title = ButterKnife.findById(spinnerView, R.id.spinner_title);
    title.setText(array[0]);
    getToolbar().addView(spinnerView);
    spinnerView.setOnClickListener(view -> {
      ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
      adapter.addAll(array);
      ListPopupWindow window = new ListPopupWindow(this);
      window.setAdapter(adapter);
      window.setOnItemClickListener((parent, spinnerItem, position, id) -> {
        window.dismiss();
        switch (position) {
          case 0:
            presenter.onMovieShortChanged(MovieSortType.Popular);
            break;
          case 1:
            presenter.onMovieShortChanged(MovieSortType.TopRated);
            break;
        }
      });
      window.setAnchorView(spinnerView);
      window.setVerticalOffset(-(spinnerView.getHeight() / 2));
      window.show();
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