package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;
import ru.rinekri.udacitypopularmovies.R;

abstract public class BaseMvpActivity<D> extends MvpAppCompatActivity implements BaseMvpView<D> {

  protected abstract ActivityConfig provideActivityConfig();
  protected void initView() {}

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityConfig config = provideActivityConfig();

    setContentView(config.contentRes());
    initActionBar(config);
    ButterKnife.bind(this);
    initView();
  }

  private void initActionBar(ActivityConfig config) {
    //TODO: Transfer Toolbar and AppBar from each layout to shell
    Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
    setSupportActionBar(toolbar);

    final ActionBar ab = getSupportActionBar();
    if (config.titleRes() != 0) {
      ab.setTitle(config.titleRes());
    }
    if (!config.titleText().trim().equals("")) {
      ab.setTitle(config.titleText());
    }
    ab.setDisplayHomeAsUpEnabled(config.useBackButton());
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