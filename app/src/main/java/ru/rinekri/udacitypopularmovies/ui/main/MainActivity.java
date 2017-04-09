package ru.rinekri.udacitypopularmovies.ui.main;

import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import ru.rinekri.udacitypopularmovies.BuildConfig;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.models.MovieInfo;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MovieInfo> implements MainView {
  @BindView(R.id.text_view)
  TextView textView;

  @InjectPresenter
  public MainPresenter presenter;

  @ProvidePresenter
  public MainPresenter providePresenter() {
    return new MainPresenter();
  }

  @Override
  protected ActivityConfig provideActivityConfig() {
    return ActivityConfig.builder()
      .contentRes(R.layout.activity_main)
      .titleRes(R.string.app_name)
      .build();
  }

  @Override
  protected void initView() {
    textView.setText(BuildConfig.DB_MOVIE_API_KEY);
  }
}