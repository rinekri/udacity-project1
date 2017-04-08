package ru.rinekri.udacitypopularmovies.ui.main;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.network.models.Foo;
import ru.rinekri.udacitypopularmovies.ui.base.ActivityConfig;
import ru.rinekri.udacitypopularmovies.ui.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<Foo> implements MainView {

  @InjectPresenter
  public MainPresenter presenter;

  @ProvidePresenter
  public MainPresenter providePresnter() {
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
  }
}