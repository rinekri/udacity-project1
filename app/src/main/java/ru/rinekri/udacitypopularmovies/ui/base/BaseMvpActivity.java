package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;

abstract public class BaseMvpActivity<D> extends MvpAppCompatActivity implements BaseMvpView<D> {

  protected abstract ActivityConfig provideActivityConfig();
  protected void initView() {}

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityConfig config = provideActivityConfig();

    setContentView(config.contentRes());
    if (getActionBar() != null) {
      getActionBar().setTitle(config.titleRes());
    }
    ButterKnife.bind(this);
    initView();
  }

  //TODO: Add logic to manage ELCE states
  @Override
  public void showContent(D data) {}

  @Override
  public void showEmpty() {}

  @Override
  public void showError(String message) {}

  @Override
  public void showLoading() {}
}