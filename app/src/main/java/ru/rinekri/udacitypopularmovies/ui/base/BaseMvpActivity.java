package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;

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
    if (getSupportActionBar() != null) {
      initActionBar(getSupportActionBar(), config);
    }
    ButterKnife.bind(this);
    initView();
  }

  private void initActionBar(@NonNull ActionBar actionBar, ActivityConfig config) {
    if (config.titleRes() != 0) {
      actionBar.setTitle(config.titleRes());
    }
    if (!config.titleText().trim().equals("")) {
      actionBar.setTitle(config.titleText());
    }
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