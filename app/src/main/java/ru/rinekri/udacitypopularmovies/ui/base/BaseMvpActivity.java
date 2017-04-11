package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;
import ru.rinekri.udacitypopularmovies.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

abstract public class BaseMvpActivity<D> extends MvpAppCompatActivity implements BaseMvpView<D> {

  protected abstract ActivityConfig provideActivityConfig();
  protected void initView() {}

  private View errorView;
  private View emptyView;
  private View progressView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityConfig config = provideActivityConfig();

    setContentView(config.contentRes());
    ButterKnife.bind(this);
    initActionBar(config);
    initElceViews(config);
    initView();
  }

  private void initElceViews(ActivityConfig config) {
    emptyView = ButterKnife.findById(this, config.emptyViewId());
    errorView = ButterKnife.findById(this, config.errorViewId());
    progressView = ButterKnife.findById(this, config.progressViewId());

    //TODO: Add logic to correctly manage ELCE states with content
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

  @Override
  public void showContent(D data) {
    errorView.setVisibility(GONE);
    emptyView.setVisibility(GONE);
    progressView.setVisibility(GONE);
  }

  @Override
  public void showEmpty() {
    errorView.setVisibility(GONE);
    emptyView.setVisibility(VISIBLE);
    progressView.setVisibility(GONE);
  }

  @Override
  public void showError(String message) {
    errorView.setVisibility(VISIBLE);
    emptyView.setVisibility(View.GONE);
    progressView.setVisibility(GONE);
  }

  @Override
  public void showLoading() {
    errorView.setVisibility(View.GONE);
    emptyView.setVisibility(View.GONE);
    progressView.setVisibility(VISIBLE);
  }
}