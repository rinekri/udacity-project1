package ru.rinekri.udacitypopularmovies.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;
import ru.rinekri.udacitypopularmovies.R;
import ru.rinekri.udacitypopularmovies.ui.base.models.ActivityConfig;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

abstract public class BaseMvpActivity<D> extends MvpAppCompatActivity implements BaseMvpView<D> {

  protected abstract ActivityConfig provideActivityConfig();

  protected void initView() {
  }

  private TextView errorView;
  private TextView emptyView;
  private ProgressBar progressView;
  private View contentView;
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityConfig config = provideActivityConfig();

    setContentView(config.contentViewRes());
    ButterKnife.bind(this);
    initActionBar(config);
    initElceViews(config);
    switchToInitState();
    initView();
  }

  private void initActionBar(ActivityConfig config) {
    //TODO: Transfer Toolbar and AppBar from each layout to shell
    toolbar = ButterKnife.findById(this, R.id.toolbar);
    setSupportActionBar(toolbar);

    final ActionBar ab = getSupportActionBar();
    if (config.titleRes() != 0) {
      ab.setTitle(config.titleRes());
    } else {
      ab.setTitle(config.titleText());
    }
    ab.setDisplayHomeAsUpEnabled(config.useBackButton());
    if (config.useBackButton()) {
      toolbar.setNavigationOnClickListener(view -> onBackPressed());
    } else {
      toolbar.setNavigationOnClickListener(null);
    }
  }

  private void initElceViews(ActivityConfig config) {
    emptyView = ButterKnife.findById(this, config.elceEmptyViewId());
    errorView = ButterKnife.findById(this, config.elceErrorViewId());
    progressView = ButterKnife.findById(this, config.elceProgressViewId());
    contentView = ButterKnife.findById(this, config.contentContainerId());
    Integer gravity;
    if (config.alignElceCenter()) {
      gravity = Gravity.CENTER;
    } else {
      gravity = Gravity.CENTER_HORIZONTAL;
    }
    emptyView.setGravity(gravity);
    errorView.setGravity(gravity);
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
    params.gravity = gravity;
    progressView.setLayoutParams(params);
  }

  @Override
  public void showViewContent(D data) {
    switchToInitState();
  }

  @Override
  public void showEmpty(@Nullable @StringRes Integer messageRes) {
    errorView.setVisibility(GONE);
    emptyView.setVisibility(VISIBLE);
    progressView.setVisibility(GONE);
    contentView.setVisibility(GONE);
    if (messageRes != null) {
      emptyView.setText(getString(messageRes));
    } else {
      emptyView.setText(getString(R.string.empty_default));
    }
  }

  @Override
  public void showError(@Nullable String message) {
    errorView.setVisibility(VISIBLE);
    emptyView.setVisibility(View.GONE);
    progressView.setVisibility(GONE);
    contentView.setVisibility(GONE);
    if (message != null) {
      errorView.setText(message);
    } else {
      errorView.setText(getString(R.string.error_default));
    }
  }

  @Override
  public void showLoading() {
    errorView.setVisibility(View.GONE);
    emptyView.setVisibility(View.GONE);
    progressView.setVisibility(VISIBLE);
    contentView.setVisibility(GONE);
  }

  private void switchToInitState() {
    errorView.setVisibility(GONE);
    emptyView.setVisibility(GONE);
    progressView.setVisibility(GONE);
    contentView.setVisibility(VISIBLE);
  }

  @NonNull
  protected Toolbar getToolbar() {
    return toolbar;
  }
}