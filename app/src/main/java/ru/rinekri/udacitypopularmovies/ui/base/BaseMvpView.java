package ru.rinekri.udacitypopularmovies.ui.base;


import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

import ru.rinekri.udacitypopularmovies.ui.base.models.ErrorConfig;

public interface BaseMvpView<D> extends MvpView {
  void showViewContent(D data);
  void showLoading();
  void showEmpty(@Nullable @StringRes Integer messageRes);
  void showError(ErrorConfig errorConfig);
}