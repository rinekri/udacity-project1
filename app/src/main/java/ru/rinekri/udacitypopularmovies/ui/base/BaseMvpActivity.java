package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

abstract public class BaseMvpActivity<D> extends MvpAppCompatActivity implements BaseMvpView<D> {

  abstract ActivityConfig provideActivityConfig();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityConfig config = provideActivityConfig();

    setContentView(config.contentRes());
    if (getActionBar() != null) {
      getActionBar().setTitle(config.titleRes());
    }
  }

  @Override
  public void showContent(D data) {}

  @Override
  public void showEmpty() {}

  @Override
  public void showError(String message) {}

  @Override
  public void showLoading() {}
}